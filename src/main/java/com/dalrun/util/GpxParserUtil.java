  package com.dalrun.util;

  import java.io.File;
  import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
  import java.util.Date;
  import java.util.List;

  import javax.xml.parsers.DocumentBuilderFactory;

  import org.springframework.stereotype.Component;
  import org.w3c.dom.Document;
  import org.w3c.dom.Node;
  import org.w3c.dom.NodeList;

  import com.dalrun.dto.GpxDataDto;

  public class GpxParserUtil {

	  public static List<GpxDataDto> parseGPXFile(File file) throws Exception {
		  
		    List<GpxDataDto> points = new ArrayList<>(); // 넘길 데이터

		    // xml 파싱 빌드
		    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    
		    // xml 파일을 Document로 파싱하기
		    Document doc = factory.newDocumentBuilder().parse(file);
		    doc.getDocumentElement().normalize();

		    // <trkseg> 안에 <trkpt>섹션 별로 데이터 저장되어 있음.
		    NodeList trkseg = doc.getElementsByTagName("trkseg");
		    
		    // <trkpt>
		    NodeList trkpts = trkseg.item(0).getChildNodes();
		    System.out.println("측정 데이터 수 : " + trkpts.getLength());
		    
		    // 데이터 추출
	        for (int j = 0; j < trkpts.getLength(); j++) {
	            Node trkpt = trkpts.item(j);

	            if (trkpt.getNodeType() == Node.ELEMENT_NODE) {
	                // 위도
	                double lat = Double.parseDouble(trkpt.getAttributes().getNamedItem("lat").getNodeValue());

	                // 경도
	                double lon = Double.parseDouble(trkpt.getAttributes().getNamedItem("lon").getNodeValue());

	                // 고도
	                double ele = 0.0;
	                Node eleNode = trkpt.getFirstChild();	// eleNode = <ele>
	                if (eleNode != null && eleNode.getNodeName().equals("ele")) {
	                    ele = Double.parseDouble(eleNode.getTextContent());
	                }

	                // 측정 시간
	                String time = null;
	                Node timeNode = trkpt.getLastChild();	// timeNode = <time>
	                if (timeNode != null && timeNode.getNodeName().equals("time")) {
	                    String timeStr = timeNode.getTextContent();
	                   // LocalDateTime dateT = LocalDateTime.parse(timeStr, DateTimeFormatter.ISO_DATE_TIME);
	                    time = timeStr.substring(timeStr.indexOf("T") + 1, timeStr.indexOf("Z"));
	                }


	                GpxDataDto gpxData = new GpxDataDto();
	                gpxData.setLatitude(lat);
	                gpxData.setLongitude(lon);
	                gpxData.setAltitude(ele);
	                gpxData.setmTime(time);
	                points.add(gpxData);
	            }
		    }
		    return points;
		}

  }
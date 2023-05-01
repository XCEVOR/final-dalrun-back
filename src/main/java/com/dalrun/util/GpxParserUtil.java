  package com.dalrun.util;

  import java.io.File;
  import java.text.SimpleDateFormat;
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

    public static List<GpxDataDto> parseGPXFile(File file) throws Exception{

      List<GpxDataDto> points	 = new ArrayList<>();	// 넘길 데이터

      // xml 파싱 빌드
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      // xml 파일을 Document로 파싱하
      Document doc = factory.newDocumentBuilder().parse(file);
      doc.getDocumentElement().normalize();

      // 각 데이터가 <trkpts> 단위로나눠짐
      NodeList trkpts = doc.getElementsByTagName("trkpts");

      // 단위 별 데이터 넣기
      for (int i = 0; i < trkpts.getLength(); i++) {

        // trkpt 하나 씩 보기
        Node trkpt = trkpts.item(i);

        // 위도
        double lat = Double.parseDouble(trkpt.getAttributes().getNamedItem("lat").getNodeValue());

        // 경도
        double lon = Double.parseDouble(trkpt.getAttributes().getNamedItem("lon").getNodeValue());

        // 고도
        double ele = 0.0;
        if (trkpt.hasChildNodes()) {
                   Node eleNode = trkpt.getFirstChild();
                   if (eleNode.getNodeName().equals("ele")) {
                       ele = Double.parseDouble(eleNode.getTextContent());
                   }
               }

        // 측정 시간
        Date time =  null;
        if (trkpt.hasChildNodes()) {
          Node timeNode = trkpt.getFirstChild();
          if (timeNode.getNodeName().equals("time")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            time = dateFormat.parse(timeNode.getTextContent());
          }
        }
        GpxDataDto gpxData = new GpxDataDto();
              gpxData.setLatitude(lat);
              gpxData.setLongitude(lon);
              gpxData.setAltitude(ele);
              gpxData.setmTime(time.toString()); // or you can convert to any desired format
              points.add(gpxData);
      }
      return points;
    }

  }
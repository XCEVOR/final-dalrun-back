  package com.dalrun.util;

  import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.dalrun.dto.GpxDataDto;

  public class GpxParserUtil {
	  
	  // 이동 거리 구하기
	  private static double calDistance(double lat1, double lon1, double lat2, double lon2) {
		   
		  	// 지구 반지름 (km)
		    final int R = 6371;
		    
		    // 위도, 경도 차이 구하기 
		    double latDistance = Math.toRadians(lat2 - lat1);
		    double lonDistance = Math.toRadians(lon2 - lon1);
		    
		    // 본격적인 이동 거리 구하기
		    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
		            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
		            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		    return R * c * 1000; // m단위로 변환
		}
	  
	  // 이동 시간 구하기
	  private static int calTimeDifference(String time1, String time2) {
		    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		    try {
		        Date date1 = sdf.parse(time1);
		        Date date2 = sdf.parse(time2);
		        long diff = date2.getTime() - date1.getTime();	// ms 단위
		        int timeDifference = (int) (diff / 1000); // 초 단위로 변환
		        return timeDifference;
		    } catch (ParseException e) {
		        e.printStackTrace();
		        return 0;
		    }
		}
	  
	  // 고도 차이 구하기
	  private static double calAltitudeDifference(double ele1, double ele2) {
	      return Math.abs(ele1 - ele2);
	  }
	  
	  // 경사도 계산하기
	  private static double calSlope(double altitudeDifference, double distance) {
	      if (distance == 0) {
	          return 0;
	      }
	      return (altitudeDifference / distance) * 100;
	  }


	  // gpx 파일 parser
	  public static List<GpxDataDto> parseGPXFile(File file) throws Exception {
		  
		    List<GpxDataDto> points = new ArrayList<>(); // 넘길 데이터
		    
		    // 초 당 이동 거리, 이동 시간 구하기용
		    GpxDataDto previousPoint = null;

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
	        for (int i = 0; i < trkpts.getLength(); i++) {
	            Node trkpt = trkpts.item(i);

	            if (trkpt.getNodeType() == Node.ELEMENT_NODE) {
	                // 위도
	                double lat = Double.parseDouble(trkpt.getAttributes().getNamedItem("lat").getNodeValue());

	                // 경도
	                double lon = Double.parseDouble(trkpt.getAttributes().getNamedItem("lon").getNodeValue());

	                // 고도
	                double ele = 0.0;

	                // 측정 시간
	                String time = null;

	                // 순회하며 <ele>와 <time> 노드를 찾기
	                NodeList childNodes = trkpt.getChildNodes();
	                for (int k = 0; k < childNodes.getLength(); k++) {
	                    Node childNode = childNodes.item(k);

	                    if (childNode.getNodeType() == Node.ELEMENT_NODE) {
	                        if (childNode.getNodeName().equals("ele")) {
	                            ele = Double.parseDouble(childNode.getTextContent());	// 고도
	                        } else if (childNode.getNodeName().equals("time")) {
	                            String timeStr = childNode.getTextContent();
	                            time = timeStr.substring(timeStr.indexOf("T") + 1, timeStr.indexOf("Z")); // 시간
	                        }
	                    }
	                }

	                // 데이터 Dto에 삽입
	                GpxDataDto gpxData = new GpxDataDto();
	                gpxData.setLatitude(lat);
	                gpxData.setLongitude(lon);
	                gpxData.setAltitude(ele);
	                gpxData.setmTime(time);
	                
	                // 초 당 이동 거리 및 시간 계산
	                if (previousPoint != null) {
	                    double distance = calDistance(previousPoint.getLatitude(), previousPoint.getLongitude(), lat, lon);
	                    int timeDifference = calTimeDifference(previousPoint.getmTime(), time);
	                    double altitudeDifference = calAltitudeDifference(previousPoint.getAltitude(), ele);
	                    double slope = calSlope(altitudeDifference, distance); // 경사도 계산
	                    
	                    // 데이터 Dto에 삽입
	                    gpxData.setDistance(distance);	// 이동 거리 삽입
	                    gpxData.setTimeDiff(timeDifference); // 이동 시간 삽입
	                    gpxData.setSlope(slope); // 경사도 삽입
	                } else {
	                	// 첫 번쨰 row
	                    gpxData.setDistance(0);
	                    gpxData.setTimeDiff(0);
	                    gpxData.setSlope(0); // 첫번째 row의 경사도는 0
	                }
	                
	                // 리스트에 담기
	                points.add(gpxData);
	                previousPoint = gpxData;
	            }
		    }
		    return points;
		}

  }
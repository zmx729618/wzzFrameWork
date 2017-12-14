package org.wzz.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wzz.test.service.DummyDataFetcher;
import org.wzz.test.service.DummyDataFetcher.TemperatureAnomaly;


@Controller
public class ChartController {
	
	@RequestMapping("chart/amcharts_key.txt")
	@ResponseBody
	public String key() {
		return "AMCHART-LNKS-1966-6679-1965-1082";
	}
	
	@RequestMapping("chart/show")
	public String show() {
		System.out.println("ChartController.show()");
		return "report/chart";
	}
	
	@RequestMapping("chart/auto")
	public String auto() {
		System.out.println("ChartController.auto()");
		return "report/auto";
	}
	
	
	@RequestMapping("chart/data")
	@ResponseBody
	public String data() {
//		String xml = "<chart><series><value xid=\"1\">1950</value>" +
//				"</series><graphs><graph gid=\"1\"><value xid=\"1\" color=\"#318DBD\">-0.307</value></graph>" +
//				"<graph gid=\"2\"><value xid=\"1\">-0.171</value></graph></graphs></chart>";
		TemperatureAnomaly[] temperatureAnomalyArray = DummyDataFetcher.getDummyData();
		StringBuilder output = new StringBuilder();
		for (TemperatureAnomaly data : temperatureAnomalyArray) {
			output.append(data.getYear()).append(";").append(data.getAnomaly()).append(";")
					.append(data.getSmoothed()).append("\n");
		}
		System.out.println(output.toString());
		return output.toString();
	}
	
	@RequestMapping("chart/autodata")
	@ResponseBody
	public String autodata() {
		
		
		
		TemperatureAnomaly[] temperatureAnomalyArray = DummyDataFetcher.getDummyData();
		StringBuilder output = new StringBuilder();
		for (TemperatureAnomaly data : temperatureAnomalyArray) {
			output.append(data.getYear()).append(";").append(data.getAnomaly()).append(";")
					.append(data.getSmoothed()).append("\n");
		}
		System.out.println(output.toString());
		return output.toString();
	}
	
	
	
	
}

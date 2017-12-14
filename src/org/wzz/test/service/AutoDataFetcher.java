package org.wzz.test.service;

import java.util.Date;

/**
 * 报表演示的模拟数据提供类.
 * 
 * @author calvin
 */
public class AutoDataFetcher {

	public static PriceDate[] getDummyData() {

		return new PriceDate[] { new PriceDate(52),new PriceDate(52),new PriceDate(52),new PriceDate(52),
				new PriceDate(52),new PriceDate(52),new PriceDate(52),new PriceDate(52),new PriceDate(52),
				new PriceDate(52),new PriceDate(52),new PriceDate(52),new PriceDate(52),new PriceDate(52),
				new PriceDate(52),new PriceDate(52),new PriceDate(52),new PriceDate(52),new PriceDate(52),
				 };
	}

	/**
	 * 年度气温记录类.
	 * 
	 * @author calvin
	 */
	public static class PriceDate {
		private Date date = new Date();
		private double price;
		
		public PriceDate(double price) {
			this.price = price;
		}

		public PriceDate(Date date, double price) {
			this.date = date;
			this.price = price;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

	}
}

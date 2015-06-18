package com.yaras.surebet;

import java.text.DecimalFormat;

public class SureCalc {
	private double oran1, oran2, oran3, bahis;
	private double o1, o2, o3;
	private double yuzde, para;
	DecimalFormat f = new DecimalFormat("##.000");

	SureCalc(double oran1, double oran2, double bahis) {
		this.oran1 = oran1;
		this.oran2 = oran2;
		this.bahis = bahis;
		o1 = bahis / oran1;
		o2 = bahis / oran2;
		yuzde = (1 - (o1 + o2) / bahis) * 100;
		para = yuzde * bahis / 100;
	}

	SureCalc(double oran1, double oran2, double oranX, double bahis) {
		this.oran1 = oran1;
		this.oran2 = oran2;
		this.oran3 = oranX;
		this.bahis = bahis;
		o1 = bahis / oran1;
		o2 = bahis / oran2;
		o3 = bahis / oranX;
		yuzde = (1 - (o1 + o2 + o3) / bahis) * 100;
		para = yuzde * bahis / 100;
	}

	public String o1String() {
		return f.format(o1);
	}

	public String o2String() {
		return f.format(o2);
	}

	public String o3String() {
		return f.format(o3);
	}

	public String yuzdeString() {
		return f.format(yuzde);
	}

	public String paraString() {
		return f.format(para);
	}

	public double getYuzde() {
		return yuzde;
	}
}

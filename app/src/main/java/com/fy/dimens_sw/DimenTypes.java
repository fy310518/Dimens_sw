package com.fy.dimens_sw;


public enum DimenTypes {

    //适配Android 3.2以上   大部分手机的sw值集中在  300-460之间
	 DP_sw__320(320),  // values-sw320
	 DP_sw__360(360),
	 DP_sw__400(400),
	 DP_sw__440(440),
	 DP_sw__480(480);
	// 想生成多少自己以此类推
  
    /**
     * 屏幕最小宽度
     */
    private int swWidthDp;


    DimenTypes(int swWidthDp) {

        this.swWidthDp = swWidthDp;
    }

    public int getSwWidthDp() {
        return swWidthDp;
    }

    public void setSwWidthDp(int swWidthDp) {
        this.swWidthDp = swWidthDp;
    }

}

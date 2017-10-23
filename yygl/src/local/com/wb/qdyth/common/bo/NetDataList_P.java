package com.wb.qdyth.common.bo;


import com.wb.jdbcutils.annos.Column;
import com.wb.jdbcutils.annos.Sequence;
import com.wb.jdbcutils.annos.Table;

/**
 * NetDataList.
 */
@Table(name="NET_DATA_LIST_P"
)
public class NetDataList_P {


     private Long dataid;
     private Long lsh;
     private String data01;
     private String data02;
     private String data03;
     private String data04;
     private String data05;
     private String data06;
     private String data07;
     private String data08;
     private String data09;
     private String data10;
     private String data11;
     private String data12;
     private String data13;
     private String data14;
     private String data15;
     private String data16;
     private String data17;
     private String data18;
     private String data19;
     private String data20;
     private String data21;
     private String data22;
     private String data23;
     private String data24;
     private String data25;
     private String data26;
     private String data27;
     private String data28;
     private String data29;
     private String data30;
     private String status;

    public NetDataList_P() {
    }

	
    public NetDataList_P(long dataid) {
        this.dataid = dataid;
    } 
    @Sequence(name="SEQUENCE", sequencename="SEQ_DATAID")
    @Column(id=true,name="DATAID")
    public Long getDataid() {
        return this.dataid;
    }
    
    public void setDataid(Long dataid) {
        this.dataid = dataid;
    }
    
    @Column(name="LSH", precision=16, scale=0)
    public Long getLsh() {
        return this.lsh;
    }
    
    public void setLsh(Long lsh) {
        this.lsh = lsh;
    }
    
    @Column(name="DATA01", length=100)
    public String getData01() {
        return this.data01;
    }
    
    public void setData01(String data01) {
        this.data01 = data01;
    }
    
    @Column(name="DATA02", length=500)
    public String getData02() {
        return this.data02;
    }
    
    public void setData02(String data02) {
        this.data02 = data02;
    }
    
    @Column(name="DATA03", length=500)
    public String getData03() {
        return this.data03;
    }
    
    public void setData03(String data03) {
        this.data03 = data03;
    }
    
    @Column(name="DATA04", length=500)
    public String getData04() {
        return this.data04;
    }
    
    public void setData04(String data04) {
        this.data04 = data04;
    }
    
    @Column(name="DATA05", length=500)
    public String getData05() {
        return this.data05;
    }
    
    public void setData05(String data05) {
        this.data05 = data05;
    }
    
    @Column(name="DATA06", length=500)
    public String getData06() {
        return this.data06;
    }
    
    public void setData06(String data06) {
        this.data06 = data06;
    }
    
    @Column(name="DATA07", length=500)
    public String getData07() {
        return this.data07;
    }
    
    public void setData07(String data07) {
        this.data07 = data07;
    }
    
    @Column(name="DATA08", length=500)
    public String getData08() {
        return this.data08;
    }
    
    public void setData08(String data08) {
        this.data08 = data08;
    }
    
    @Column(name="DATA09", length=500)
    public String getData09() {
        return this.data09;
    }
    
    public void setData09(String data09) {
        this.data09 = data09;
    }
    
    @Column(name="DATA10", length=500)
    public String getData10() {
        return this.data10;
    }
    
    public void setData10(String data10) {
        this.data10 = data10;
    }
    
    @Column(name="DATA11", length=500)
    public String getData11() {
        return this.data11;
    }
    
    public void setData11(String data11) {
        this.data11 = data11;
    }
    
    @Column(name="DATA12", length=500)
    public String getData12() {
        return this.data12;
    }
    
    public void setData12(String data12) {
        this.data12 = data12;
    }
    
    @Column(name="DATA13", length=500)
    public String getData13() {
        return this.data13;
    }
    
    public void setData13(String data13) {
        this.data13 = data13;
    }
    
    @Column(name="DATA14", length=500)
    public String getData14() {
        return this.data14;
    }
    
    public void setData14(String data14) {
        this.data14 = data14;
    }
    
    @Column(name="DATA15", length=500)
    public String getData15() {
        return this.data15;
    }
    
    public void setData15(String data15) {
        this.data15 = data15;
    }
    
    @Column(name="DATA16", length=500)
    public String getData16() {
        return this.data16;
    }
    
    public void setData16(String data16) {
        this.data16 = data16;
    }
    
    @Column(name="DATA17", length=500)
    public String getData17() {
        return this.data17;
    }
    
    public void setData17(String data17) {
        this.data17 = data17;
    }
    
    @Column(name="DATA18", length=500)
    public String getData18() {
        return this.data18;
    }
    
    public void setData18(String data18) {
        this.data18 = data18;
    }
    
    @Column(name="DATA19", length=500)
    public String getData19() {
        return this.data19;
    }
    
    public void setData19(String data19) {
        this.data19 = data19;
    }
    
    @Column(name="DATA20", length=500)
    public String getData20() {
        return this.data20;
    }
    
    public void setData20(String data20) {
        this.data20 = data20;
    }
    
    @Column(name="DATA21", length=500)
    public String getData21() {
        return this.data21;
    }
    
    public void setData21(String data21) {
        this.data21 = data21;
    }
    
    @Column(name="DATA22", length=500)
    public String getData22() {
        return this.data22;
    }
    
    public void setData22(String data22) {
        this.data22 = data22;
    }
    
    @Column(name="DATA23", length=500)
    public String getData23() {
        return this.data23;
    }
    
    public void setData23(String data23) {
        this.data23 = data23;
    }
    
    @Column(name="DATA24", length=500)
    public String getData24() {
        return this.data24;
    }
    
    public void setData24(String data24) {
        this.data24 = data24;
    }
    
    @Column(name="DATA25", length=500)
    public String getData25() {
        return this.data25;
    }
    
    public void setData25(String data25) {
        this.data25 = data25;
    }
    
    @Column(name="DATA26", length=500)
    public String getData26() {
        return this.data26;
    }
    
    public void setData26(String data26) {
        this.data26 = data26;
    }
    
    @Column(name="DATA27", length=500)
    public String getData27() {
        return this.data27;
    }
    
    public void setData27(String data27) {
        this.data27 = data27;
    }
    
    @Column(name="DATA28", length=500)
    public String getData28() {
        return this.data28;
    }
    
    public void setData28(String data28) {
        this.data28 = data28;
    }
    
    @Column(name="DATA29", length=1000)
    public String getData29() {
        return this.data29;
    }
    
    public void setData29(String data29) {
        this.data29 = data29;
    }
    
    @Column(name="DATA30", length=1000)
    public String getData30() {
        return this.data30;
    }
    
    public void setData30(String data30) {
        this.data30 = data30;
    }
    
   
    
 
    
    @Column(name="STATUS", length=3)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

}



package com.wb.qdyth.common.bo;


import com.wb.jdbcutils.annos.Column;
import com.wb.jdbcutils.annos.Sequence;
import com.wb.jdbcutils.annos.Table;

/**
 * NetDataList.
 */
@Table(name="NET_DATA_LIST"
)
public class NetDataList {


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
     private String data31;
     private String data32;
     private String data33;
     private String data34;
     private String data35;
     private String data36;
     private String data37;
     private String data38;
     private String data39;
     private String data40;
     private String data41;
     private String data42;
     private String data43;
     private String data44;
     private String data45;
     private String data46;
     private String data47;
     private String data48;
     private String data49;
     private String data50;
     private String data51;
     private String data52;
     private String data53;
     private String data54;
     private String data55;
     private String data56;
     private String data57;
     private String data58;
     private String data59;
     private String data60;
     private String data61;
     private String data62;
     private String data63;
     private String data64;
     private String data65;
     private String data66;
     private String data67;
     private String data68;
     private String data69;
     private String data70;
     private String data71;
     private String data72;
     private String data73;
     private String data74;
     private String data75;
     private String data76;
     private String data77;
     private String data78;
     private String data79;
     private String data80;
     private String data81;
     private String data82;
     private String data83;
     private String data84;
     private String data85;
     private String data86;
     private String data87;
     private String data88;
     private String data89;
     private String data90;
     private String data91;
     private String data92;
     private String data93;
     private String data94;
     private String data95;
     private String data96;
     private String data97;
     private String data98;
     private String data99;
     private String data100;
     private String status;

    public NetDataList() {
    }

	
    public NetDataList(long dataid) {
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
    
    @Column(name="DATA02", length=100)
    public String getData02() {
        return this.data02;
    }
    
    public void setData02(String data02) {
        this.data02 = data02;
    }
    
    @Column(name="DATA03", length=100)
    public String getData03() {
        return this.data03;
    }
    
    public void setData03(String data03) {
        this.data03 = data03;
    }
    
    @Column(name="DATA04", length=100)
    public String getData04() {
        return this.data04;
    }
    
    public void setData04(String data04) {
        this.data04 = data04;
    }
    
    @Column(name="DATA05", length=100)
    public String getData05() {
        return this.data05;
    }
    
    public void setData05(String data05) {
        this.data05 = data05;
    }
    
    @Column(name="DATA06", length=100)
    public String getData06() {
        return this.data06;
    }
    
    public void setData06(String data06) {
        this.data06 = data06;
    }
    
    @Column(name="DATA07", length=100)
    public String getData07() {
        return this.data07;
    }
    
    public void setData07(String data07) {
        this.data07 = data07;
    }
    
    @Column(name="DATA08", length=100)
    public String getData08() {
        return this.data08;
    }
    
    public void setData08(String data08) {
        this.data08 = data08;
    }
    
    @Column(name="DATA09", length=100)
    public String getData09() {
        return this.data09;
    }
    
    public void setData09(String data09) {
        this.data09 = data09;
    }
    
    @Column(name="DATA10", length=100)
    public String getData10() {
        return this.data10;
    }
    
    public void setData10(String data10) {
        this.data10 = data10;
    }
    
    @Column(name="DATA11", length=100)
    public String getData11() {
        return this.data11;
    }
    
    public void setData11(String data11) {
        this.data11 = data11;
    }
    
    @Column(name="DATA12", length=100)
    public String getData12() {
        return this.data12;
    }
    
    public void setData12(String data12) {
        this.data12 = data12;
    }
    
    @Column(name="DATA13", length=100)
    public String getData13() {
        return this.data13;
    }
    
    public void setData13(String data13) {
        this.data13 = data13;
    }
    
    @Column(name="DATA14", length=100)
    public String getData14() {
        return this.data14;
    }
    
    public void setData14(String data14) {
        this.data14 = data14;
    }
    
    @Column(name="DATA15", length=100)
    public String getData15() {
        return this.data15;
    }
    
    public void setData15(String data15) {
        this.data15 = data15;
    }
    
    @Column(name="DATA16", length=100)
    public String getData16() {
        return this.data16;
    }
    
    public void setData16(String data16) {
        this.data16 = data16;
    }
    
    @Column(name="DATA17", length=100)
    public String getData17() {
        return this.data17;
    }
    
    public void setData17(String data17) {
        this.data17 = data17;
    }
    
    @Column(name="DATA18", length=100)
    public String getData18() {
        return this.data18;
    }
    
    public void setData18(String data18) {
        this.data18 = data18;
    }
    
    @Column(name="DATA19", length=100)
    public String getData19() {
        return this.data19;
    }
    
    public void setData19(String data19) {
        this.data19 = data19;
    }
    
    @Column(name="DATA20", length=100)
    public String getData20() {
        return this.data20;
    }
    
    public void setData20(String data20) {
        this.data20 = data20;
    }
    
    @Column(name="DATA21", length=100)
    public String getData21() {
        return this.data21;
    }
    
    public void setData21(String data21) {
        this.data21 = data21;
    }
    
    @Column(name="DATA22", length=100)
    public String getData22() {
        return this.data22;
    }
    
    public void setData22(String data22) {
        this.data22 = data22;
    }
    
    @Column(name="DATA23", length=100)
    public String getData23() {
        return this.data23;
    }
    
    public void setData23(String data23) {
        this.data23 = data23;
    }
    
    @Column(name="DATA24", length=100)
    public String getData24() {
        return this.data24;
    }
    
    public void setData24(String data24) {
        this.data24 = data24;
    }
    
    @Column(name="DATA25", length=100)
    public String getData25() {
        return this.data25;
    }
    
    public void setData25(String data25) {
        this.data25 = data25;
    }
    
    @Column(name="DATA26", length=100)
    public String getData26() {
        return this.data26;
    }
    
    public void setData26(String data26) {
        this.data26 = data26;
    }
    
    @Column(name="DATA27", length=100)
    public String getData27() {
        return this.data27;
    }
    
    public void setData27(String data27) {
        this.data27 = data27;
    }
    
    @Column(name="DATA28", length=100)
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
    
    @Column(name="DATA31", length=100)
    public String getData31() {
        return this.data31;
    }
    
    public void setData31(String data31) {
        this.data31 = data31;
    }
    
    @Column(name="DATA32", length=100)
    public String getData32() {
        return this.data32;
    }
    
    public void setData32(String data32) {
        this.data32 = data32;
    }
    
    @Column(name="DATA33", length=100)
    public String getData33() {
        return this.data33;
    }
    
    public void setData33(String data33) {
        this.data33 = data33;
    }
    
    @Column(name="DATA34", length=100)
    public String getData34() {
        return this.data34;
    }
    
    public void setData34(String data34) {
        this.data34 = data34;
    }
    
    @Column(name="DATA35", length=100)
    public String getData35() {
        return this.data35;
    }
    
    public void setData35(String data35) {
        this.data35 = data35;
    }
    
    @Column(name="DATA36", length=100)
    public String getData36() {
        return this.data36;
    }
    
    public void setData36(String data36) {
        this.data36 = data36;
    }
    
    @Column(name="DATA37", length=100)
    public String getData37() {
        return this.data37;
    }
    
    public void setData37(String data37) {
        this.data37 = data37;
    }
    
    @Column(name="DATA38", length=100)
    public String getData38() {
        return this.data38;
    }
    
    public void setData38(String data38) {
        this.data38 = data38;
    }
    
    @Column(name="DATA39", length=100)
    public String getData39() {
        return this.data39;
    }
    
    public void setData39(String data39) {
        this.data39 = data39;
    }
    
    @Column(name="DATA40", length=100)
    public String getData40() {
        return this.data40;
    }
    
    public void setData40(String data40) {
        this.data40 = data40;
    }
    
    @Column(name="DATA41", length=100)
    public String getData41() {
        return this.data41;
    }
    
    public void setData41(String data41) {
        this.data41 = data41;
    }
    
    @Column(name="DATA42", length=100)
    public String getData42() {
        return this.data42;
    }
    
    public void setData42(String data42) {
        this.data42 = data42;
    }
    
    @Column(name="DATA43", length=100)
    public String getData43() {
        return this.data43;
    }
    
    public void setData43(String data43) {
        this.data43 = data43;
    }
    
    @Column(name="DATA44", length=100)
    public String getData44() {
        return this.data44;
    }
    
    public void setData44(String data44) {
        this.data44 = data44;
    }
    
    @Column(name="DATA45", length=100)
    public String getData45() {
        return this.data45;
    }
    
    public void setData45(String data45) {
        this.data45 = data45;
    }
    
    @Column(name="DATA46", length=100)
    public String getData46() {
        return this.data46;
    }
    
    public void setData46(String data46) {
        this.data46 = data46;
    }
    
    @Column(name="DATA47", length=100)
    public String getData47() {
        return this.data47;
    }
    
    public void setData47(String data47) {
        this.data47 = data47;
    }
    
    @Column(name="DATA48", length=100)
    public String getData48() {
        return this.data48;
    }
    
    public void setData48(String data48) {
        this.data48 = data48;
    }
    
    @Column(name="DATA49", length=100)
    public String getData49() {
        return this.data49;
    }
    
    public void setData49(String data49) {
        this.data49 = data49;
    }
    
    @Column(name="DATA50", length=100)
    public String getData50() {
        return this.data50;
    }
    
    public void setData50(String data50) {
        this.data50 = data50;
    }
    
    @Column(name="DATA51", length=100)
    public String getData51() {
        return this.data51;
    }
    
    public void setData51(String data51) {
        this.data51 = data51;
    }
    
    @Column(name="DATA52", length=100)
    public String getData52() {
        return this.data52;
    }
    
    public void setData52(String data52) {
        this.data52 = data52;
    }
    
    @Column(name="DATA53", length=100)
    public String getData53() {
        return this.data53;
    }
    
    public void setData53(String data53) {
        this.data53 = data53;
    }
    
    @Column(name="DATA54", length=100)
    public String getData54() {
        return this.data54;
    }
    
    public void setData54(String data54) {
        this.data54 = data54;
    }
    
    @Column(name="DATA55", length=100)
    public String getData55() {
        return this.data55;
    }
    
    public void setData55(String data55) {
        this.data55 = data55;
    }
    
    @Column(name="DATA56", length=100)
    public String getData56() {
        return this.data56;
    }
    
    public void setData56(String data56) {
        this.data56 = data56;
    }
    
    @Column(name="DATA57", length=100)
    public String getData57() {
        return this.data57;
    }
    
    public void setData57(String data57) {
        this.data57 = data57;
    }
    
    @Column(name="DATA58", length=4000)
    public String getData58() {
        return this.data58;
    }
    
    public void setData58(String data58) {
        this.data58 = data58;
    }
    
    @Column(name="DATA59", length=100)
    public String getData59() {
        return this.data59;
    }
    
    public void setData59(String data59) {
        this.data59 = data59;
    }
    
    @Column(name="DATA60", length=100)
    public String getData60() {
        return this.data60;
    }
    
    public void setData60(String data60) {
        this.data60 = data60;
    }
    
    @Column(name="DATA61", length=100)
    public String getData61() {
        return this.data61;
    }
    
    public void setData61(String data61) {
        this.data61 = data61;
    }
    
    @Column(name="DATA62", length=100)
    public String getData62() {
        return this.data62;
    }
    
    public void setData62(String data62) {
        this.data62 = data62;
    }
    
    @Column(name="DATA63", length=100)
    public String getData63() {
        return this.data63;
    }
    
    public void setData63(String data63) {
        this.data63 = data63;
    }
    
    @Column(name="DATA64", length=100)
    public String getData64() {
        return this.data64;
    }
    
    public void setData64(String data64) {
        this.data64 = data64;
    }
    
    @Column(name="DATA65", length=100)
    public String getData65() {
        return this.data65;
    }
    
    public void setData65(String data65) {
        this.data65 = data65;
    }
    
    @Column(name="DATA66", length=100)
    public String getData66() {
        return this.data66;
    }
    
    public void setData66(String data66) {
        this.data66 = data66;
    }
    
    @Column(name="DATA67", length=100)
    public String getData67() {
        return this.data67;
    }
    
    public void setData67(String data67) {
        this.data67 = data67;
    }
    
    @Column(name="DATA68", length=100)
    public String getData68() {
        return this.data68;
    }
    
    public void setData68(String data68) {
        this.data68 = data68;
    }
    
    @Column(name="DATA69", length=100)
    public String getData69() {
        return this.data69;
    }
    
    public void setData69(String data69) {
        this.data69 = data69;
    }
    
    @Column(name="DATA70", length=100)
    public String getData70() {
        return this.data70;
    }
    
    public void setData70(String data70) {
        this.data70 = data70;
    }
    
    @Column(name="DATA71", length=100)
    public String getData71() {
        return this.data71;
    }
    
    public void setData71(String data71) {
        this.data71 = data71;
    }
    
    @Column(name="DATA72", length=100)
    public String getData72() {
        return this.data72;
    }
    
    public void setData72(String data72) {
        this.data72 = data72;
    }
    
    @Column(name="DATA73", length=100)
    public String getData73() {
        return this.data73;
    }
    
    public void setData73(String data73) {
        this.data73 = data73;
    }
    
    @Column(name="DATA74", length=100)
    public String getData74() {
        return this.data74;
    }
    
    public void setData74(String data74) {
        this.data74 = data74;
    }
    
    @Column(name="DATA75", length=100)
    public String getData75() {
        return this.data75;
    }
    
    public void setData75(String data75) {
        this.data75 = data75;
    }
    
    @Column(name="DATA76", length=100)
    public String getData76() {
        return this.data76;
    }
    
    public void setData76(String data76) {
        this.data76 = data76;
    }
    
    @Column(name="DATA77", length=100)
    public String getData77() {
        return this.data77;
    }
    
    public void setData77(String data77) {
        this.data77 = data77;
    }
    
    @Column(name="DATA78", length=100)
    public String getData78() {
        return this.data78;
    }
    
    public void setData78(String data78) {
        this.data78 = data78;
    }
    
    @Column(name="DATA79", length=100)
    public String getData79() {
        return this.data79;
    }
    
    public void setData79(String data79) {
        this.data79 = data79;
    }
    
    @Column(name="DATA80", length=100)
    public String getData80() {
        return this.data80;
    }
    
    public void setData80(String data80) {
        this.data80 = data80;
    }
    
    @Column(name="DATA81", length=100)
    public String getData81() {
        return this.data81;
    }
    
    public void setData81(String data81) {
        this.data81 = data81;
    }
    
    @Column(name="DATA82", length=100)
    public String getData82() {
        return this.data82;
    }
    
    public void setData82(String data82) {
        this.data82 = data82;
    }
    
    @Column(name="DATA83", length=100)
    public String getData83() {
        return this.data83;
    }
    
    public void setData83(String data83) {
        this.data83 = data83;
    }
    
    @Column(name="DATA84", length=100)
    public String getData84() {
        return this.data84;
    }
    
    public void setData84(String data84) {
        this.data84 = data84;
    }
    
    @Column(name="DATA85", length=100)
    public String getData85() {
        return this.data85;
    }
    
    public void setData85(String data85) {
        this.data85 = data85;
    }
    
    @Column(name="DATA86", length=100)
    public String getData86() {
        return this.data86;
    }
    
    public void setData86(String data86) {
        this.data86 = data86;
    }
    
    @Column(name="DATA87", length=100)
    public String getData87() {
        return this.data87;
    }
    
    public void setData87(String data87) {
        this.data87 = data87;
    }
    
    @Column(name="DATA88", length=100)
    public String getData88() {
        return this.data88;
    }
    
    public void setData88(String data88) {
        this.data88 = data88;
    }
    
    @Column(name="DATA89", length=100)
    public String getData89() {
        return this.data89;
    }
    
    public void setData89(String data89) {
        this.data89 = data89;
    }
    
    @Column(name="DATA90", length=100)
    public String getData90() {
        return this.data90;
    }
    
    public void setData90(String data90) {
        this.data90 = data90;
    }
    
    @Column(name="DATA91", length=100)
    public String getData91() {
        return this.data91;
    }
    
    public void setData91(String data91) {
        this.data91 = data91;
    }
    
    @Column(name="DATA92", length=100)
    public String getData92() {
        return this.data92;
    }
    
    public void setData92(String data92) {
        this.data92 = data92;
    }
    
    @Column(name="DATA93", length=100)
    public String getData93() {
        return this.data93;
    }
    
    public void setData93(String data93) {
        this.data93 = data93;
    }
    
    @Column(name="DATA94", length=100)
    public String getData94() {
        return this.data94;
    }
    
    public void setData94(String data94) {
        this.data94 = data94;
    }
    
    @Column(name="DATA95", length=100)
    public String getData95() {
        return this.data95;
    }
    
    public void setData95(String data95) {
        this.data95 = data95;
    }
    
    @Column(name="DATA96", length=100)
    public String getData96() {
        return this.data96;
    }
    
    public void setData96(String data96) {
        this.data96 = data96;
    }
    
    @Column(name="DATA97", length=100)
    public String getData97() {
        return this.data97;
    }
    
    public void setData97(String data97) {
        this.data97 = data97;
    }
    
    @Column(name="DATA98", length=100)
    public String getData98() {
        return this.data98;
    }
    
    public void setData98(String data98) {
        this.data98 = data98;
    }
    
    @Column(name="DATA99", length=100)
    public String getData99() {
        return this.data99;
    }
    
    public void setData99(String data99) {
        this.data99 = data99;
    }
    
    @Column(name="DATA100", length=100)
    public String getData100() {
        return this.data100;
    }
    
    public void setData100(String data100) {
        this.data100 = data100;
    }
    
    @Column(name="STATUS", length=3)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

}



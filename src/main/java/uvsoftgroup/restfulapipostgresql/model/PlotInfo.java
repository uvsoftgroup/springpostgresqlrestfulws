/**
 * 
 */
package uvsoftgroup.restfulapipostgresql.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class PlotInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	Long plId,plAddressId;
	String plCode,plName,plType,plNumber,plMonzaNumber,plCSNumber,plMSNumber,plRemark;
	Double plTotalArea,plTotalBuildingCoverArea,plNumberOfBuilding,plHeightFromMSL,plCenterLongitude,plCenterLatitude;
	byte [] plLayoutPicture,utilityLocationMap;
	

	@OneToMany
	@JoinColumn(name="pl_id_id")
	List<PlotInfoAuthorizationInfo> plotInfoAuthrizationInfos=new ArrayList<PlotInfoAuthorizationInfo>();
	
	@OneToMany
	@JoinColumn(name="pl_id_id")
	List<PlotInfoOwnershipInfo> plotInfoOwnershipInfos=new ArrayList<PlotInfoOwnershipInfo>();
	
	@OneToMany
	@JoinColumn(name="pl_id_id")
	List<PlotInfoPaymentInfo> plotInfoPaymentInfos=new ArrayList<PlotInfoPaymentInfo>();
	
	@OneToMany
	@JoinColumn(name="pl_id_id")
	List<PlotInfoUtilityInfo> plotInfoUtilityInfos=new ArrayList<PlotInfoUtilityInfo>();
	
	@OneToMany
	@JoinColumn(name="pl_id_id")
	List<PlotInfoBillingInfo> plotInfoBillingInfos=new ArrayList<PlotInfoBillingInfo>();
	
	@OneToMany
	@JoinColumn(name="pl_id_id")
	List<BuildingInfo> buildingInfos=new ArrayList<BuildingInfo>();
  
	public Long getPlId() {
		return plId;
	}

	public void setPlId(Long plId) {
		this.plId = plId;
	}

	public Long getPlAddressId() {
		return plAddressId;
	}

	public void setPlAddressId(Long plAddressId) {
		this.plAddressId = plAddressId;
	}

	public String getPlCode() {
		return plCode;
	}

	public void setPlCode(String plCode) {
		this.plCode = plCode;
	}

	public String getPlName() {
		return plName;
	}

	public void setPlName(String plName) {
		this.plName = plName;
	}

	public String getPlType() {
		return plType;
	}

	public void setPlType(String plType) {
		this.plType = plType;
	}

	public String getPlNumber() {
		return plNumber;
	}

	public void setPlNumber(String plNumber) {
		this.plNumber = plNumber;
	}

	public String getPlMonzaNumber() {
		return plMonzaNumber;
	}

	public void setPlMonzaNumber(String plMonzaNumber) {
		this.plMonzaNumber = plMonzaNumber;
	}

	public String getPlCSNumber() {
		return plCSNumber;
	}

	public void setPlCSNumber(String plCSNumber) {
		this.plCSNumber = plCSNumber;
	}

	public String getPlMSNumber() {
		return plMSNumber;
	}

	public void setPlMSNumber(String plMSNumber) {
		this.plMSNumber = plMSNumber;
	}

	public Double getPlTotalArea() {
		return plTotalArea;
	}

	public void setPlTotalArea(Double plTotalArea) {
		this.plTotalArea = plTotalArea;
	}

	public Double getPlTotalBuildingCoverArea() {
		return plTotalBuildingCoverArea;
	}

	public void setPlTotalBuildingCoverArea(Double plTotalBuildingCoverArea) {
		this.plTotalBuildingCoverArea = plTotalBuildingCoverArea;
	}

	public Double getPlNumberOfBuilding() {
		return plNumberOfBuilding;
	}

	public void setPlNumberOfBuilding(Double plNumberOfBuilding) {
		this.plNumberOfBuilding = plNumberOfBuilding;
	}

	public Double getPlHeightFromMSL() {
		return plHeightFromMSL;
	}

	public void setPlHeightFromMSL(Double plHeightFromMSL) {
		this.plHeightFromMSL = plHeightFromMSL;
	}

	public Double getPlCenterLongitude() {
		return plCenterLongitude;
	}

	public void setPlCenterLongitude(Double plCenterLongitude) {
		this.plCenterLongitude = plCenterLongitude;
	}

	public Double getPlCenterLatitude() {
		return plCenterLatitude;
	}

	public void setPlCenterLatitude(Double plCenterLatitude) {
		this.plCenterLatitude = plCenterLatitude;
	}

	public byte[] getPlLayoutPicture() {
		return plLayoutPicture;
	}

	public void setPlLayoutPicture(byte[] plLayoutPicture) {
		this.plLayoutPicture = plLayoutPicture;
	}

	public byte[] getUtilityLocationMap() {
		return utilityLocationMap;
	}

	public void setUtilityLocationMap(byte[] utilityLocationMap) {
		this.utilityLocationMap = utilityLocationMap;
	}

	public String getPlRemark() {
		return plRemark;
	}

	public void setPlRemark(String plRemark) {
		this.plRemark = plRemark;
	}

	public List<PlotInfoAuthorizationInfo> getPlotInfoAuthrizationInfos() {
		return plotInfoAuthrizationInfos;
	}

	public void setPlotInfoAuthrizationInfos(
			List<PlotInfoAuthorizationInfo> plotInfoAuthrizationInfos) {
		this.plotInfoAuthrizationInfos = plotInfoAuthrizationInfos;
	}
	
	
	public List<PlotInfoOwnershipInfo> getPlotInfoOwnershipInfos() {
		return plotInfoOwnershipInfos;
	}

	public void setPlotInfoOwnershipInfos(
			List<PlotInfoOwnershipInfo> plotInfoOwnershipInfos) {
		this.plotInfoOwnershipInfos = plotInfoOwnershipInfos;
	}

	public List<PlotInfoPaymentInfo> getPlotInfoPaymentInfos() {
		return plotInfoPaymentInfos;
	}

	public void setPlotInfoPaymentInfos(
			List<PlotInfoPaymentInfo> plotInfoPaymentInfos) {
		this.plotInfoPaymentInfos = plotInfoPaymentInfos;
	}

	public List<PlotInfoUtilityInfo> getPlotInfoUtilityInfos() {
		return plotInfoUtilityInfos;
	}

	public void setPlotInfoUtilityInfos(
			List<PlotInfoUtilityInfo> plotInfoUtilityInfos) {
		this.plotInfoUtilityInfos = plotInfoUtilityInfos;
	}

	public List<BuildingInfo> getBuildingInfos() {
		return buildingInfos;
	}

	public void setBuildingInfos(List<BuildingInfo> buildingInfos) {
		this.buildingInfos = buildingInfos;
	}

	public List<PlotInfoBillingInfo> getPlotInfoBillingInfos() {
		return plotInfoBillingInfos;
	}

	public void setPlotInfoBillingInfos(
			List<PlotInfoBillingInfo> plotInfoBillingInfos) {
		this.plotInfoBillingInfos = plotInfoBillingInfos;
	}
	
}

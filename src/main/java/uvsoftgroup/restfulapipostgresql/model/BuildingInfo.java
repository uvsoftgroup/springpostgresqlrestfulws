/**
 * 
 */
package uvsoftgroup.restfulapipostgresql.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class BuildingInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	Long buId,buAddressId,buPlId;
	String buCode,buName,buUseType,buRemark;
	BigDecimal buNumberOfFloor,buTotalHeight,buNumberOfFloorUnit,buTotalGroundArea,buTotalFloorArea,buSetBackFront;
	BigDecimal buSetBackBack,buSetBackRight,buSetBackLeft,buCenterLongitude,buCenterLatitude;
	byte [] buLayoutPicture;

	public Long getBuId() {
		return buId;
	}
	public void setBuId(Long buId) {
		this.buId = buId;
	}
	public Long getBuAddressId() {
		return buAddressId;
	}
	public void setBuAddressId(Long buAddressId) {
		this.buAddressId = buAddressId;
	}
	public Long getBuPlId() {
		return buPlId;
	}
	public void setBuPlId(Long buPlId) {
		this.buPlId = buPlId;
	}
	public String getBuCode() {
		return buCode;
	}
	public void setBuCode(String buCode) {
		this.buCode = buCode;
	}
	public String getBuName() {
		return buName;
	}
	public void setBuName(String buName) {
		this.buName = buName;
	}
	public String getBuUseType() {
		return buUseType;
	}
	public void setBuUseType(String buUseType) {
		this.buUseType = buUseType;
	}
	public BigDecimal getBuNumberOfFloor() {
		return buNumberOfFloor;
	}
	public void setBuNumberOfFloor(BigDecimal buNumberOfFloor) {
		this.buNumberOfFloor = buNumberOfFloor;
	}
	public BigDecimal getBuTotalHeight() {
		return buTotalHeight;
	}
	public void setBuTotalHeight(BigDecimal buTotalHeight) {
		this.buTotalHeight = buTotalHeight;
	}
	public BigDecimal getBuNumberOfFloorUnit() {
		return buNumberOfFloorUnit;
	}
	public void setBuNumberOfFloorUnit(BigDecimal buNumberOfFloorUnit) {
		this.buNumberOfFloorUnit = buNumberOfFloorUnit;
	}
	public BigDecimal getBuTotalGroundArea() {
		return buTotalGroundArea;
	}
	public void setBuTotalGroundArea(BigDecimal buTotalGroundArea) {
		this.buTotalGroundArea = buTotalGroundArea;
	}
	public BigDecimal getBuTotalFloorArea() {
		return buTotalFloorArea;
	}
	public void setBuTotalFloorArea(BigDecimal buTotalFloorArea) {
		this.buTotalFloorArea = buTotalFloorArea;
	}
	public BigDecimal getBuSetBackFront() {
		return buSetBackFront;
	}
	public void setBuSetBackFront(BigDecimal buSetBackFront) {
		this.buSetBackFront = buSetBackFront;
	}
	public BigDecimal getBuSetBackBack() {
		return buSetBackBack;
	}
	public void setBuSetBackBack(BigDecimal buSetBackBack) {
		this.buSetBackBack = buSetBackBack;
	}
	public BigDecimal getBuSetBackRight() {
		return buSetBackRight;
	}
	public void setBuSetBackRight(BigDecimal buSetBackRight) {
		this.buSetBackRight = buSetBackRight;
	}
	public BigDecimal getBuSetBackLeft() {
		return buSetBackLeft;
	}
	public void setBuSetBackLeft(BigDecimal buSetBackLeft) {
		this.buSetBackLeft = buSetBackLeft;
	}
	public BigDecimal getBuCenterLongitude() {
		return buCenterLongitude;
	}
	public void setBuCenterLongitude(BigDecimal buCenterLongitude) {
		this.buCenterLongitude = buCenterLongitude;
	}
	public BigDecimal getBuCenterLatitude() {
		return buCenterLatitude;
	}
	public void setBuCenterLatitude(BigDecimal buCenterLatitude) {
		this.buCenterLatitude = buCenterLatitude;
	}
	public byte[] getBuLayoutPicture() {
		return buLayoutPicture;
	}
	public void setBuLayoutPicture(byte[] buLayoutPicture) {
		this.buLayoutPicture = buLayoutPicture;
	}
	public String getBuRemark() {
		return buRemark;
	}
	public void setBuRemark(String buRemark) {
		this.buRemark = buRemark;
	}
	
	
}

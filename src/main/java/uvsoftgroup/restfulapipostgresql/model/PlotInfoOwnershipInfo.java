/**
 * 
 */
package uvsoftgroup.restfulapipostgresql.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class PlotInfoOwnershipInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	    Long owId,owAddressId,owPlId;
		String owFullName,owStatus,owRemark,owType;
		Date owAppliedDate,owLastModifiedDate,owApprovedDate;
		
		public PlotInfoOwnershipInfo(){
			super();
		}
		public Long getOwId() {
			return owId;
		}
		public void setOwId(Long owId) {
			this.owId = owId;
		}
		public Long getOwAddressId() {
			return owAddressId;
		}
		public void setOwAddressId(Long owAddressId) {
			this.owAddressId = owAddressId;
		}
		public String getOwFullName() {
			return owFullName;
		}
		public void setOwFullName(String owFullName) {
			this.owFullName = owFullName;
		}
		public String getOwType() {
			return owType;
		}
		public void setOwType(String owType) {
			this.owType = owType;
		}
		public Date getOwAppliedDate() {
			return owAppliedDate;
		}
		public void setOwAppliedDate(Date owAppliedDate) {
			this.owAppliedDate = owAppliedDate;
		}
		public Date getOwLastModifiedDate() {
			return owLastModifiedDate;
		}
		public void setOwLastModifiedDate(Date owLastModifiedDate) {
			this.owLastModifiedDate = owLastModifiedDate;
		}
		public Date getOwApprovedDate() {
			return owApprovedDate;
		}
		public void setOwApprovedDate(Date owApprovedDate) {
			this.owApprovedDate = owApprovedDate;
		}
		public String getOwStatus() {
			return owStatus;
		}
		public void setOwStatus(String owStatus) {
			this.owStatus = owStatus;
		}
		public String getOwRemark() {
			return owRemark;
		}
		public void setOwRemark(String owRemark) {
			this.owRemark = owRemark;
		}
		public Long getOwPlId() {
			return owPlId;
		}
		public void setOwPlId(Long owPlId) {
			this.owPlId = owPlId;
		}

}

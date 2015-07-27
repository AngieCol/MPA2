package it.polimi.awt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




import javax.persistence.Table;


@Entity
@Table(name="Mountains")
public class Mountains {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idMountains;
	
	
	
		private String name;
		
				
		private Float prominence;
		
		private Float elevation;
		
		private String latitudeDecimal;
		
		
		private String longitudeDecimal;
		
		private Float icon;

		public int getIdMountains() {
			return idMountains;
		}

		public void setIdMountains(int idMountains) {
			this.idMountains = idMountains;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		

		public Float getProminence() {
			return prominence;
		}

		public void setProminence(Float prominence) {
			this.prominence = prominence;
		}

		public Float getElevation() {
			return elevation;
		}

		public void setElevation(Float elevation) {
			this.elevation = elevation;
		}

		public String getLatitudeDecimal() {
			return latitudeDecimal;
		}

		public void setLatitudeDecimal(String latitudeDecimal) {
			this.latitudeDecimal = latitudeDecimal;
		}

		public String getLongitudeDecimal() {
			return longitudeDecimal;
		}

		public void setLongitudeDecimal(String longitudeDecimal) {
			this.longitudeDecimal = longitudeDecimal;
		}

		public Float getIcon() {
			return icon;
		}

		public void setIcon(Float icon) {
			this.icon = icon;
		}
		

		
	}

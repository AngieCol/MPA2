package it.polimi.awt.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DecimalDV;

@Entity
public class Media {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int idMedia;
	private String url;
	private String type;
	private String latitudeDecimal;
	private String longitudeDecimal;
	private String title;
	

		/*
	@ManyToOne
	@JoinColumn(name="idMountains", referencedColumnName = "id")
	private Mountains mountain;
	
	
		public Mountains getMountain() {
		return mountain;
	}

	public void setMountain(Mountains mountain) {
		this.mountain = mountain;
	}
*/
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		

		public int getIdMedia() {
			return idMedia;
		}

		public void setIdMedia(int idMedia) {
			this.idMedia = idMedia;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
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

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}


		
	}

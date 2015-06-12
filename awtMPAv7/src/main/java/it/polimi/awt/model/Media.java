package it.polimi.awt.model;

import javax.persistence.Entity;
import javax.persistence.Id;




import javax.persistence.ManyToOne;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DecimalDV;

@Entity
public class Media {
	
	@Id private int idMedia;
	
		private String url;

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
		
		
		
		
	}

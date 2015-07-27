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
public class Keyword {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int idKeyword;
/*	
	@ManyToOne
	@JoinColumn(name="idMountains", referencedColumnName = "id")
	private Mountains mountain;
		

	*/
	

		public int getIdMedia() {
			return idKeyword;
		}

		public void setIdMedia(int idMedia) {
			this.idKeyword = idMedia;
		}

		
		
		
		
	}

package org.hibernate.bugs;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ENTITY_SIMPLE_OK")
public class EntitySimpleOk {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	Integer id;

	@Column(name = "MY_TYPE")
	MyType myType;

}
package org.hibernate.bugs;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "ENTITY_OK")
public class EntityOk {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	Integer id;

	@ElementCollection
	@CollectionTable(name = "ENTITY_OK_TO_MY_TYPE", joinColumns = @JoinColumn(name = "ENTITY_OK", nullable = false))
	@Column(name = "MY_TYPE")
	Collection<MyType> myTypes = new ArrayList<MyType>();

}
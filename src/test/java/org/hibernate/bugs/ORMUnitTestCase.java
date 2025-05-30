package org.hibernate.bugs;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.testing.orm.junit.DomainModel;
import org.hibernate.testing.orm.junit.ServiceRegistry;
import org.hibernate.testing.orm.junit.SessionFactory;
import org.hibernate.testing.orm.junit.SessionFactoryScope;
import org.hibernate.testing.orm.junit.Setting;
import org.junit.jupiter.api.Test;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM,
 * using its built-in unit test framework. Although ORMStandaloneTestCase is
 * perfectly acceptable as a reproducer, usage of this class is much preferred.
 * Since we nearly always include a regression test with bug fixes, providing
 * your reproducer using this method simplifies the process.
 * <p>
 * What's even better? Fork hibernate-orm itself, add your test case directly to
 * a module's unit tests, then submit it as a PR!
 */
@DomainModel(annotatedClasses = {
		// mappings
		EntitySimpleOk.class, EntityOk.class, EntityNok.class }, xmlMappings = {})
@ServiceRegistry(settings = {
		// For your own convenience to see generated queries:
		@Setting(name = AvailableSettings.SHOW_SQL, value = "true"),
		@Setting(name = AvailableSettings.FORMAT_SQL, value = "true"), })
@SessionFactory
class ORMUnitTestCase {

	@Test
	public void entitySimpleOk(SessionFactoryScope scope) throws Exception {
		scope.inTransaction(s -> {
			EntitySimpleOk entity = new EntitySimpleOk();
			entity.myType = MyType.TYPE_02;
			s.persist(entity);
		});
	}

	@Test
	public void entityOk(SessionFactoryScope scope) throws Exception {
		scope.inTransaction(s -> {
			EntityOk entity = new EntityOk();
			entity.myTypes.add(MyType.TYPE_02);
			s.persist(entity);
		});
	}

	@Test
	public void entityNok(SessionFactoryScope scope) throws Exception {
		scope.inTransaction(s -> {
			EntityNok entity = new EntityNok();
			entity.myTypes.add(MyType.TYPE_02);
			s.persist(entity);
		});
	}
}



import org.oregami.data.DatabaseFiller;
import org.oregami.data.JPAInitializer;
import org.oregami.guice.OregamiGuiceInjector;

import play.Application;
import play.GlobalSettings;
public class Global extends GlobalSettings {

	@Override
	public void onStart(Application app) {
		OregamiGuiceInjector.get().getInstance(JPAInitializer.class);
		initData();
	}
	
	
    private void initData() {
    	DatabaseFiller databaseFiller = OregamiGuiceInjector.get().getInstance(DatabaseFiller.class);
    	databaseFiller.initData();
	}

	@Override
	public <A> A getControllerInstance(Class<A> clazz) {
		return OregamiGuiceInjector.get().getInstance(clazz);
	}
	
}
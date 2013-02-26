

import org.oregami.data.DatabaseFiller;
import org.oregami.data.JPAInitializer;
import org.oregami.data.OregamiGuiceModule;

import play.Application;
import play.GlobalSettings;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;
public class Global extends GlobalSettings {

	public static final Injector INJECTOR = createInjector();

	@Override
	public void onStart(Application app) {
		INJECTOR.getInstance(JPAInitializer.class);
		initData();
	}
	
	
    private void initData() {
    	DatabaseFiller databaseFiller = INJECTOR.getInstance(DatabaseFiller.class);
    	databaseFiller.initData();
	}

	private static Injector createInjector() {
    	return Guice.createInjector(
    			new OregamiGuiceModule(), new JpaPersistModule("data")
    	);
    }
    
	@Override
	public <A> A getControllerInstance(Class<A> clazz) {
		return INJECTOR.getInstance(clazz);
	}
	
}
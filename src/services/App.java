package services;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("/")
public class App extends Application {
	
	
	@Override
	public Set<Object> getSingletons() {
		HashSet<Object> singletons = new HashSet<Object>();
		singletons.add(new BudgetResource());
		singletons.add(new TableResource());
		singletons.add(new AccountResource());
		singletons.add(new CategoryService());
		return singletons;
	}

}
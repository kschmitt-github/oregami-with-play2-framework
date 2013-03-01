/*
 * Copyright 2012 Steve Chaloner
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.oregami.security;

import org.oregami.guice.OregamiGuiceInjector;

import play.mvc.Http;
import play.mvc.Result;
import be.objectify.deadbolt.core.models.Subject;
import be.objectify.deadbolt.java.AbstractDeadboltHandler;
import be.objectify.deadbolt.java.DynamicResourceHandler;

/**
 * @author Steve Chaloner (steve@objectify.be)
 */
public class MyDeadboltHandler extends AbstractDeadboltHandler
{

	private MyDeadboltGuiceContainer guice;
	
	public MyDeadboltGuiceContainer getGuice() {
		if (guice==null) {
			guice = OregamiGuiceInjector.get().getInstance(MyDeadboltGuiceContainer.class);
		}
		return guice;
	}
	
    public Result beforeAuthCheck(Http.Context context)
    {
        // returning null means that everything is OK.  Return a real result if you want a redirect to a login page or
        // somewhere else
        return null;
    }

    public Subject getSubject(Http.Context context)
    {
        // in a real application, the user name would probably be in the session following a login process
//        return AuthorisedUser.findByUserName("steve");
    	String sessionUsername = context.session().get("user");
    	if (sessionUsername==null) return null;
    	return getGuice().getUserRepository().findByUsername(sessionUsername);
    }

    public DynamicResourceHandler getDynamicResourceHandler(Http.Context context)
    {
        return new MyDynamicResourceHandler();
    }

    @Override
    public Result onAuthFailure(Http.Context context,
                                String content)
    {
        return ok(views.html.accessdenied.render());
    }
}

package driver;

import controller.LoginPageController;

public class LibrarySystemAppRunner {

	/**
	 * 
	 * Main starter method, entry point for the Java program.
	 */
	public static void main(String[] args) {
		LoginPageController baseApp = new LoginPageController();//Creates the only controller in application.
		baseApp.start();//Starts the application.

	}

}

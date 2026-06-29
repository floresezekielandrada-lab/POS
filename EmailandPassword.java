import java.util.HashMap;

/**

 * EMAILANDPASSWORD CLASS

 * ang class na ito ay responsable sa pag-store
 * ng lahat ng valid email at password combinations
 * 
 * gamit ang HashMap para sa mabilis na search
 * Email = Key, Password = Value
 */
public class EmailandPassword {
	
	// HashMap para mag-store ng credentials
	// Format: email -> password
	private HashMap<String, String> logininfo;
	
	/**
	 * CONSTRUCTOR
	 * Nag-initialize ng HashMap at nagdadagdag ng sample data
	 */
	public EmailandPassword() {
		
		// Gumawa ng bagong HashMap
		logininfo = new HashMap<String, String>();
		
		// Nagdadagdag ng sample email at password
		// SECURITY WARNING: Huwag mo gawin ito sa real application!
		// Sa real apps, i-hash ang passwords at i-store sa database
		
		logininfo.put("floresezekielandrada@gmail.com", "pizza123");
		logininfo.put("admin@gmail.com", "PASSWORD123");
		logininfo.put("bro@gmail.com", "abc123");
	}
	
	/**
	 * GET LOGIN INFO METHOD
	 * Nagbabalik ng HashMap na may lahat ng credentials
	 * 
	 * @return HashMap na may email bilang key at password bilang value
	 */
	public HashMap<String, String> getLoginInfo() {
		return logininfo;
	}
	
	/**
	 * ADD CREDENTIALS METHOD
	 * Para sa future use - dagdagan ng bagong email/password
	 * 
	 * @param email - Email address ng user
	 * @param password - Password ng user
	 */
	public void addCredential(String email, String password) {
		if (email != null && !email.isEmpty() && password != null && !password.isEmpty()) {
			logininfo.put(email, password);
		} else {
			System.out.println("Error: Email at password ay hindi dapat empty");
		}
	}
	
	/**
	 * VERIFY CREDENTIALS METHOD
	 * Nag-verify kung tama ang email at password
	 * 
	 * @param email - Email na i-check
	 * @param password - Password na i-check
	 * @return true kung tama, false kung mali
	 */
	public boolean verifyCredentials(String email, String password) {
		
		// Check 1: Kung may email sa HashMap
		if (!logininfo.containsKey(email)) {
			return false; // Email hindi found
		}
		
		// Check 2: Kung tama ang password para sa email na ito
		if (logininfo.get(email).equals(password)) {
			return true; // Password tama!
		}
		
		return false; // Password mali
	}
}

/**

 * MAIN CLASS - Entry Point ng Program

 * Ito ang pangunahing class na tatakbo kapag
 * nag-start ang program. Responsable sa pag-initialize
 * ng lahat ng components
 */
public class Main {
	
	public static void main(String[] args) {
		
		// STEP 1: Gumawa ng object para sa email at passwords
		// Ito ay mag-store ng lahat ng valid credentials
		EmailandPassword emailandPassword = new EmailandPassword();
		
		// STEP 2: I-pass ang credentials sa LoginPage
		// Para ma-check niya kung tama ang login info ng user
		LoginPage loginPage = new LoginPage(emailandPassword.getLoginInfo());
	}
}

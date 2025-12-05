import java.io.Console;
import javax.swing.*;


public class PasswordMask {

    /**
     * Read a password with masking.
     * - If running in a real console: use Console.readPassword()
     * - Otherwise (IDE): use a Swing JPasswordField dialog (masked)
     *
     * Note: Swing dialog requires a GUI environment (works in NetBeans).
     */
    public static String readMasked(String prompt) {
        // Try console first (works when running from CMD / terminal)
        Console console = System.console();
        if (console != null) {
            char[] pw = console.readPassword(prompt);
            return (pw == null) ? "" : new String(pw);
        }

        // Fallback to Swing dialog (works inside IDE)
        final JPasswordField pf = new JPasswordField();
        final Object[] message = { prompt, pf };
        // Show dialog on Event Dispatch Thread and block until user responds
        int option = JOptionPane.showConfirmDialog(null, message, "Password Entry", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            return new String(pf.getPassword());
        } else {
            return "";
        }
    }
}
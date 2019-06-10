import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Dan Crosby  CIT360
 * 3/6/19
 * A Servlet to demonstrate the battle results from the setup provided by index.jsp.
 */
@WebServlet(name = "Skaro", urlPatterns={"/Servlet"})
public class Skaro extends HttpServlet {

    /**
     * Method doPost - The main method for receiving the form submission and creating a response.
     *
     * @param  request - a link to the contents of the submitting page.
     * @param  response - any response will be sent here.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        //Define variables for calculating output
        String output = "<html><head></head><body><frameset>";
        String battleNarrative = "";
        String battleResults = "";

        try {
            //Determine which Dalek squadron to use.
            String d1 = request.getParameter("d1");
            String d2 = request.getParameter("d2");
            String d3 = request.getParameter("d3");
            //Determine the attack target
            String myTarget = request.getParameter("myTarget");

            //Checkboxes are not present in HTML submissions unless the box was checked, so I'm checking
            //for whether or not the field is present, rather than whether or not the box is checked.
            if (d1!=null) {
                output=output + "<img src='img/daleksec.jpg' height='100px' width='100px'>";
                battleNarrative=battleNarrative + "<p>Fighting a battle with Dalek Sec";
            }
            else if (d2!=null) {
                output=output + "<img src='img/dalekwarriors.jpg' height='100px' width='100px'>";
                battleNarrative=battleNarrative + "<p>Fighting a battle with Dalek Warriors";
            }
            else if (d3!=null) {
                output=output + "<img src='img/supremecouncil.jpg' height='100px' width='100px'>";
                battleNarrative=battleNarrative + "<p>Fighting a battle with the Dalek Supreme Council";
            }
            else {
                output=output+ "No Dalek armies were specified.   As a result, your attack has failed, and the late night television comics are all laughing at the Daleks.</HTML>";
                out.println(output + "</frameset></body></html>");
                return;
            }

            //Add the "vs" image that goes between the Dalek and the Target.
            output=output + "<img src='img/vs.jpg' height='100px' width='100px'>";

            //These lines for debugging only
            //s=s+"<p>myTarget=" + myTarget + "</p>";
            //s=s+"<p>Attack Destination : " + myTarget + "</p>";

            //Depending on the target of the attack, construct the final output.
            //At this point there is no fancy randomization logic so the result is calculated based on
            //the attack target rather than any random circumstance.
            if (myTarget.equals("1")) {
                output=output + "<img src='img/dallas.jpg' height='100px' width='100px'>";
                battleNarrative=battleNarrative + " against the city of Dallas!</p>";
                battleResults="<H4>It's a lucky day in Dallas, Dr. Who arrived in his Tardis and foiled the Dalek's.</H4>";
                battleResults=battleResults + "<img src='img/tardis.png' height='200px' width='100px'>";
            }
            else if (myTarget.equals("2")) {
                output=output + "<img src='img/moon.jpg' height='100px' width='100px'>";
                battleNarrative=battleNarrative + " against the city of Dallas!</p>";
                battleResults="<H4>On finding the moon uninhabited, the Daleks became angry and destroyed the moon.</H4>";
                battleResults=battleResults + "<img src='img/moondestroyed.jpg' height='200px' width='200px'>";
            }
            else if (myTarget.equals("3")) {
                output=output + "<img src='img/byuidaho.jpg' height='100px' width='100px'>";
                battleNarrative=battleNarrative + " against BYU Idaho!</p>";
                battleResults="<H4>The Dalek's tried to use their ray gun, but the faith of BYU Idaho students was unstoppable.</H4>";
                battleResults=battleResults + "<img src='img/faith.jpg' height='200px' width='200px'>";
            }

            //Output the combined output
            output=output+battleNarrative + "<h2>Battle Results:</h2>" + battleResults +"</frameset></body></html>";
            out.println(output);
        }
        catch (Exception ex) {
            output="<HTML><H3>The web page that called this servlet was missing a required field.</H3><H3>As a tragic result, the entire planet was destroyed by the Dakeks.</H3></HTML>";
            out.println(output);
            throw new ServletException();
        }
    }
    /**
     * Method doGet - This application relies on Post rather than get, so this is for error handling only.
     *
     * @param  request - a link to the contents of the submitting page.
     * @param  response - any response will be sent here.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("This resources can only be called via form post to the Skaro servlet.");
        throw new ServletException();
    }
}

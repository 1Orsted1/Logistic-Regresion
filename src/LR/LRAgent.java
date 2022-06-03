/**
 * @author : ftm
**/

package logistic.agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.Agent;
import java.util.List;
import logistic.controller.*;

public class LRAgent extends Agent {
	
	private Gui myGui;

  protected void setup() {
	  
	myGui = new Gui(this);
	myGui.showGui();
  }
  
  // Put agent clean-up operations here
	protected void takeDown() {
		// Close the GUI
		myGui.dispose();
		// Printout a dismissal message
		System.out.println("LR-agent " + getAID().getName() + " terminating.");
	}
  
    public void simpleLR(String input) {
		addBehaviour(new OneShotBehaviour() {
			public void action() {
				double[][] dataSet = new double[][]{
        {148,1},
        {85,0},
        {183,1},
        {89,0},
        {137,1},
        {116,0},
        {78,1},
        };
        String[] userRawValues;                             

        
				userRawValues = input.split(",");

				double [] inputs = new double [userRawValues.length];

				for (int i = 0; i < userRawValues.length; i++) {
					inputs[i] = Double.parseDouble(userRawValues[i]);
				}

				LogisticRegression lr = new LogisticRegression();

				lr.setData(dataSet);
		
        System.out.println(lr.classify(inputs));

			}
		} );
	}
	
	public void multipleLR(String input) {
		addBehaviour(new OneShotBehaviour() {
			public void action() {
				double[][] dataSet = new double[][]{
        {780, 4.0, 3, 1},
        {750, 3.9, 4, 1},
        {690, 3.3, 3, 0},
        {710, 3.7, 5, 1},
        {680, 3.9, 4, 0},
        {730, 3.7, 6, 1},
        {690, 2.3, 1, 0},
        {720, 3.3, 4, 1},
        {740, 3.3, 5, 1},
        }; 
 
	      String[] userRawValues;

        userRawValues = input.split(",");

				double [] inputs = new double [userRawValues.length];

				for (int i = 0; i < userRawValues.length; i++) {
					inputs[i] = Double.parseDouble(userRawValues[i]);
				}

        LogisticRegression lr = new LogisticRegression();
  
				lr.setData(dataSet);
		    System.out.println(lr.classify(inputs));
			}
		} );
	}
}


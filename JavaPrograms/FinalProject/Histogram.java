import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.Pane;
import javafx.scene.chart.XYChart;
import java.util.*;
//Graph Histogram Extends Pane
class Histogram extends Pane {
    public int serieNumber = 1;
	final String[] stringAlphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R","S","T","U","V","W","X","Y","Z"};
    protected char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    //Counts property inside Histogram
    public int[] counts = new int[alphabet.length];
    final CategoryAxis xAxis = new CategoryAxis();
   	final NumberAxis yAxis = new NumberAxis();
    final BarChart<String,Number> barChart = new BarChart<String,Number>(xAxis,yAxis);

    public BarChart getBC(){
       	return barChart;
    }
    public Histogram(){//Construct
        barChart.setTitle("Letter Summary");
        xAxis.setLabel("A - Z");       
        yAxis.setLabel("Value");
    }
	public @SuppressWarnings("unchecked") void createHistogram(String name) {
		//I used SuppressWarnings as an annotation to the graph
		//Java kept giving me an unchecked error but i most certainly checked the outcome.

        XYChart.Series series = new XYChart.Series();
   	    series.setName(name + ": " + serieNumber);
        serieNumber+=1;     
   	    for(int x = 0; x < stringAlphabet.length; x++){
        	series.getData().add(new XYChart.Data(stringAlphabet[x], counts[x]));
   	    }
        barChart.getData().add(series);

   	}//3 Variables, x,y and barchat. setLabels. create a series, loop through alphabet and numbers


    //Settermethod for count to reset values
    public void resetCounts(){
        counts = new int[alphabet.length];
    }
    
    public int[] makeArray(java.io.File file) throws Exception{
        resetCounts();
        Scanner scannedFile = new Scanner(file);


        scannedFile.useDelimiter("");
        while(scannedFile.hasNext()){
            char letter = scannedFile.next().charAt(0);
            for(int i = 0; i < alphabet.length; i++){
                if(letter == alphabet[i]){
                    counts[i]+=1;
                    break;
                }
            }
        }
        //Another pretty straight forward method, grabs char at next position, checks to see if its in the alphatbet
        //If it is, breaks to save from counting any furthur than return array at end
        return counts;
    }
}//add data to BarChart, than returnBarChar
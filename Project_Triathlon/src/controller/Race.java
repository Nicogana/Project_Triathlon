package controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import model.Amateur;
import model.Athlete;
import model.City;
import model.Competitor;
import model.Country;
import model.Modality;
import model.PhysicalConditions;
import model.Stations;
import model.WeatherConditions;

public class Race {
    private City city;
    private Date date;
    private List <WeatherConditions> condition;
    private List<Athlete> athlete;
    private Modality modality;
    private double kmswimming;
    private double kmcyclism;
    private double  kmpedestrianism;
    private List<Stations> stations;
    



	public Race(City city, Date date, List<Athlete> athlete, Modality modality, double kmswimming, double kmcyclism,
			double kmpedestrianism, List<Stations> stations) {
		super();
		this.city = city;
		this.date = date;
		this.athlete = athlete;
		this.modality = modality;
		this.kmswimming = kmswimming;
		this.kmcyclism = kmcyclism;
		this.kmpedestrianism = kmpedestrianism;
		this.stations = stations;
	}



	public City getCity() {
		return city;
	}



	public void setCity(City city) {
		this.city = city;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public List<WeatherConditions> getCondition() {
		return condition;
	}



	public void setCondition(List<WeatherConditions> condition) {
		this.condition = condition;
	}



	public List<Athlete> getAthlete() {
		return athlete;
	}



	public void setAthlete(List<Athlete> athlete) {
		this.athlete = athlete;
	}



	public Modality getModality() {
		return modality;
	}



	public void setModality(Modality modality) {
		this.modality = modality;
	}



	public double getKmswimming() {
		return kmswimming;
	}



	public void setKmswimming(double kmswimming) {
		this.kmswimming = kmswimming;
	}



	public double getKmcyclism() {
		return kmcyclism;
	}



	public void setKmcyclism(double kmcyclism) {
		this.kmcyclism = kmcyclism;
	}



	public double getKmpedestrianism() {
		return kmpedestrianism;
	}



	public void setKmpedestrianism(double kmpedestrianism) {
		this.kmpedestrianism = kmpedestrianism;
	}



	public List<Stations> getStations() {
		return stations;
	}



	public void setStations(List<Stations> stations) {
		this.stations = stations;
	}

	
	public static List<Race> loadXML() throws ParserConfigurationException, SAXException, IOException {
		
		// Load the XML file
        File xmlFile = new File("triatlon.xml");

        // Create a DocumentBuilderFactory and a DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the XML file and get document
        org.w3c.dom.Document document = builder.parse(xmlFile);
  
       

        //  Print the root element
        document.getDocumentElement().normalize();
        System.out.println("Root Element: " + document.getDocumentElement().getNodeName());
        
    
        // Get objects <athlete>
        NodeList AthleteList = document.getElementsByTagName("atleta");
        System.out.println("Number of athletes: " + AthleteList.getLength());
        
        NodeList CareerList = document.getElementsByTagName("carrera");
        System.out.println("Number of Races:" + CareerList.getLength());
        

        // List for elements <athlete>
        List<Athlete> athletes = new ArrayList<>();
      
        
        // Iterate over each athlete
        for (int i = 0; i < AthleteList.getLength(); i++) {
            Node athleteNode = AthleteList.item(i);
            if (athleteNode.getNodeType() == Node.ELEMENT_NODE) {
                Element athleteElement =  (Element) athleteNode;
                
               
          
                

                int num = Integer.parseInt(athleteElement.getAttribute("numero"));
                String surname = getChildElementValue(athleteElement, "apellido");
                String name = getChildElementValue(athleteElement, "nombre");
                String id = getChildElementValue(athleteElement, "dni");
                String nationality = getChildElementValue(athleteElement, "nacionalidad");
                Date  birthDate = parseFecha(getChildElementValue(athleteElement, "fechaNacimiento"));
                String gender = getChildElementValue(athleteElement, "genero");
                String category = getChildElementValue(athleteElement, "categoria");
                double  weight = Double.parseDouble(getChildElementValue(athleteElement, "peso"));
                double  height = Double.parseDouble(getChildElementValue(athleteElement, "altura"));
                double swimmingAptitude = Double.parseDouble(getChildElementValue(athleteElement, "aptitudNatacion"));
                double cyclismAptitude = Double.parseDouble(getChildElementValue(athleteElement, "aptitudCiclismo"));
                double pedestrianismAptitude = Double.parseDouble(getChildElementValue(athleteElement, "aptitudPedestrismo"));
                double stamina = Double.parseDouble(getChildElementValue(athleteElement, "resistencia"));
                double mentalStrength = Double.parseDouble(getChildElementValue(athleteElement, "fortalezaPsicologica"));
                double percEndedRaces = Double.parseDouble(getChildElementValue(athleteElement, "porcentajeCarrerasTerminadas"));
                double economicBudget = Double.parseDouble(getChildElementValue(athleteElement, "presupuestoEconomico"));
                int ranking = Integer.parseInt(getChildElementValue(athleteElement, "ranking"));
                
                PhysicalConditions physicalconditions  = new PhysicalConditions(swimmingAptitude, cyclismAptitude, pedestrianismAptitude, stamina, mentalStrength);
                
                if (category.equalsIgnoreCase("Amateur")) {
	                Athlete athlete = new Amateur(num, surname, name, id, nationality, birthDate, gender, weight, height, percEndedRaces, economicBudget, ranking, physicalconditions);
	                athletes.add(athlete);
                }
                else {
          
                	Athlete athlete = new Competitor(num, surname, name, id, nationality, birthDate, gender, weight, height, percEndedRaces, economicBudget, ranking, physicalconditions);
                	athletes.add(athlete);	
                }
                
                
            }
            
        }
        
        
        // List for athletes
        List<Race> races = new ArrayList<>();
            
            
        for (int j = 0; j <  CareerList.getLength(); j++) {
            Node careerNode = CareerList.item(j);
               
            if (careerNode.getNodeType() == Node.ELEMENT_NODE) {
                Element careerElement =  (Element) careerNode;
            	
            
                    
                
                String cityname = getChildElementValue(careerElement, "ciudad");
                String countryname = getChildElementValue( careerElement,"pais");
                Date date = parseFecha(getChildElementValue( careerElement,"fecha"));
                String modalityname = getChildElementValue(careerElement,"modalidad");
                double swimming = Double.parseDouble(getChildElementValue(careerElement, "natacion"));
                double cyclism = Double.parseDouble(getChildElementValue(careerElement, "ciclismo"));
                double pedestrianism = Double.parseDouble(getChildElementValue(careerElement, "pedestrismo"));
                    
                    
                Country country = new Country(countryname);
                City city = new City(cityname , country);
                Modality modality = new Modality(modalityname);
                    
                    
                    
                List<Stations> stati = new ArrayList<>();
                Element provisioningstationsElement = (Element) careerElement.getElementsByTagName("puestos_aprovisionamiento").item(0);
                NodeList stationsList = provisioningstationsElement.getElementsByTagName("puesto");
                for (int p = 0; p < stationsList.getLength(); p++) {
                    Node puestoNode = stationsList.item(p);
                    if (puestoNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element puestoElement = (Element) puestoNode;
                        String tipo = puestoElement.getAttribute("tipo");
                        int numero = Integer.parseInt(puestoElement.getAttribute("numero"));
                        double distancia = Double.parseDouble(getChildElementValue(puestoElement, "distancia"));

                        Stations station = new Stations(tipo, numero, distancia);
                        stati.add(station);
                    }
                }
                    
                Race race = new Race(city, date, athletes, modality, swimming, cyclism, pedestrianism, stati);
                    
                    
                races.add(race);
            }    
        }
            
            
		return races;
        
    }
      
	
           
		

    
//Helper method for obtaining the value of a child element given its name
	private static String getChildElementValue(Element parentElement, String childElementName) {
		 NodeList nodeList = parentElement.getElementsByTagName(childElementName);
		 if (nodeList.getLength() > 0) {
		     return nodeList.item(0).getTextContent();
		 } else {
		     return ""; // Handle case where the element is not present
		 }
	}

// Method for parsing date in "yyyy-MM-dd" to Date
	private static Date parseFecha(String fechaStr) {
	    try {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        return  (Date) dateFormat.parse(fechaStr);
	    } catch (ParseException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
   
	public static void loadDatabase() {}
	//Loads the climatic changes data base



	@Override
	public String toString() {
	    
		return "Race: \n City: " + city + "\n Date: " + date + "\n Condition: " + condition + "\n Athlete: " + athlete
				+ "\n Modality:" + modality + "\n Km Swimming: " + kmswimming + "\n Km Cyclism: " + kmcyclism
				+ "\n Km Pedestrianism: " + kmpedestrianism + "\n Stations: " + stations + "\n";
	}
	
	

}

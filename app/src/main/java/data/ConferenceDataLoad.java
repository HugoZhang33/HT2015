package data;

import java.util.ArrayList;
import java.util.Hashtable;

import android.content.Context;

public class ConferenceDataLoad {


    public ConferenceDataLoad() {
    }

    public void loadConferenceInfo() {
        Conference.title = "UMAP 2015";
        Conference.startDate = "Monday, Jun.1 ";
        Conference.description = "The ACM Hypertext conference is a premium venue for high quality peer-reviewed research on hypertext theory, systems and applications. It is concerned with all aspects of modern hypertext research including social media, semantic web, dynamic and computed hypertext and hypermedia as well as narrative systems and applications. The ACM Hypertext 2014 conference will focus on the role of hypertext and hyperlink theory on the web and beyond, as a foundation for approaches and practices in the wider community - ranging from the usage of social media to the semantics of the 'Internet of Things'. We also welcome submissions that focus on the linguistic aspects of hypertext and user experience with linked entities, resources and events.";
        Conference.endDate = "Thursday, July.4 ";
        Conference.location = "Dublin, Ireland ";

    }

    public ArrayList<Keynote> loadKeynote() {
        ArrayList<Keynote> knList = new ArrayList<Keynote>();
        Keynote k;


        //FOR KEYNOTE****************
        k = new Keynote();
        k.ID = "1920";
        k.title = "Visualizing the Development of Economies, Cultural Production and Cities";
        k.description = "The evolution of economies and culture hinge on the accumulation of physically embodied information. Products such as cars, refrigerators and toothpaste, as well as works of art, such as paintings and books; and scientific discoveries, are all preserved as physically embodied information. In this presentation I will use 6000 years of cultural production data and 50 years of international trade data to study the dynamics of economic development and cultural production. When it comes to economic development, I will show that the the income of a country depends primarily on the mix of products that it makes, and that a country's product mix evolves in a predictable manner that is dictated by the network of product similarities or product space. For the dynamics of cultural production, I will show that the long term evolution of cultural production is tightly connected to the broadcasting technologies available to our species–validating the theories of Marshall McLuhan and Elizabeth Eisenstein–and to the network of global languages. All of the work I will present can be explored interactively using two data visualizations we have built called The Observatory of Economic Complexity (atlas.media.mit.edu) and Pantheon (pantheon.media.mit.edu). If time allows, I will also show how we can use computer vision and machine learning to study the evolution of a city's aesthetic components (streetscore.media.mit.edu).";
        k.date = "Tuesday, Sept.2";
        k.dayid = "2";
        k.beginTime = "09:15";
        k.endTime = "10:30";
        k.room = "Aula Magna";
        k.speakerName = "Cesar A. Hidalgo";
        k.speakerAffiliation = "";
        knList.add(k);

        k = new Keynote();
        k.ID = "1929";
        k.title = "The Wisdom of Ad-Hoc Crowds";
        k.description = "Ricardo Baeza-Yates is VP of Research for Europe and Latin America, leading the Yahoo! Research labs at Barcelona, Spain and Santiago, Chile. Until 2012 he also supervised the lab in Haifa, Israel. Until 2005 he was the director of the Center for Web Research at the Department of Computer Science of the Engineering School of the University of Chile; and ICREA Professor and founder of the Web Research Group at the Deptartament of Information and Communication Technologies of Universitat Pompeu Fabra in Barcelona, Spain. He maintains ties with both mentioned universities as a part-time professor for the Ph.D. program.His research interests includes algorithms and data structures, information retrieval, web data mining, and data visualization.";
        k.date = "Wednesday, Sept.3";
        k.dayid = "3";
        k.beginTime = "09:00";
        k.endTime = "10:30";
        k.room = "Aula Magna";
        k.speakerName = "Ricardo Baeza-Yates";
        k.speakerAffiliation = "";
        knList.add(k);

        //KEYNOTE ENDS****************

        return knList;
    }

    public ArrayList<Poster> loadPoster() {
        ArrayList<Poster> poList = new ArrayList<Poster>();
        Poster s;

        s = new Poster();
        s.ID = "1858";
        s.name = "Posters";
        s.date = "Wednesday, July9 ";
        s.day_id = "3";
        s.beginTime = "14:00";
        s.endTime = "15:30";
        s.room = "Kildecaafen and Bøgesalen";
        poList.add(s);


        return poList;
    }

    public ArrayList<Workshop> loadWorkshopsDes() {
        //this.IdtoDate();

        ArrayList<Workshop> wList = new ArrayList<Workshop>();

        Workshop s;
        s = new Workshop();
        s.ID = "1";
        s.name = "To Be Announced";
        s.date = "Monday, Sept.1";
        s.day_id = "1";
        s.beginTime = "00:00";
        s.endTime = "00:00";
        s.room = "null";
        s.content = "<p></p>";
        s.childsessionID = "1908";
        wList.add(s);

        s = new Workshop();
        s.ID = "2";
        s.name = "DataWiz 2014 - Session 1&2";
        s.date = "Monday, Sept.1";
        s.day_id = "1";
        s.beginTime = "11:00";
        s.endTime = "12:30";
        s.room = "Sala 8, Centro Extension PUC";
        s.content = "<p></p>";
        s.childsessionID = "1948";
        wList.add(s);

        s = new Workshop();
        s.ID = "3";
        s.name = "DataWiz 2014 - Session 3 - 'Data Journalism II'";
        s.date = "Monday, Sept.1";
        s.day_id = "1";
        s.beginTime = "14:00";
        s.endTime = "15:30";
        s.room = "Sala 8, Centro Extension PUC";
        s.content = "<p></p>";
        s.childsessionID = "1950";
        wList.add(s);

        s = new Workshop();
        s.ID = "4";
        s.name = "DataWiz 2014 - Session 4 - 'Data Explorations and Exploitations'";
        s.date = "Monday, Sept.1";
        s.day_id = "1";
        s.beginTime = "16:00";
        s.endTime = "18:00";
        s.room = "Sala 8, Centro Extension PUC";
        s.content = "<p></p>";
        s.childsessionID = "1951";
        wList.add(s);

        s = new Workshop();
        s.ID = "5";
        s.name = "SP 2014 - Session 1";
        s.date = "Monday, Sept.1";
        s.day_id = "1";
        s.beginTime = "09:00";
        s.endTime = "10:30";
        s.room = "Sala 2a, Centro Extension PUC";
        s.content = "<p></p>";
        s.childsessionID = "1952";
        wList.add(s);

        s = new Workshop();
        s.ID = "6";
        s.name = "SP 2014 - Session 2";
        s.date = "Monday, Sept.1";
        s.day_id = "1";
        s.beginTime = "11:00";
        s.endTime = "12:30";
        s.room = "Sala 2a, Centro Extension PUC";
        s.content = "<p></p>";
        s.childsessionID = "1953";
        wList.add(s);

        s = new Workshop();
        s.ID = "7";
        s.name = "SP 2014 - Session 3";
        s.date = "Monday, Sept.1";
        s.day_id = "1";
        s.beginTime = "14:00";
        s.endTime = "15:30";
        s.room = "Sala 2a, Centro Extension PUC";
        s.content = "<p></p>";
        s.childsessionID = "1954";
        wList.add(s);

        s = new Workshop();
        s.ID = "8";
        s.name = "DataWiz 2014 - Welcome";
        s.date = "Monday, Sept.1";
        s.day_id = "1";
        s.beginTime = "09:00";
        s.endTime = "10:30";
        s.room = "Sala 8, Centro Extension PUC";
        s.content = "<p></p>";
        s.childsessionID = "1958";
        wList.add(s);

        s = new Workshop();
        s.ID = "9";
        s.name = "LinkQS 2014";
        s.date = "Monday, Sept.1";
        s.day_id = "1";
        s.beginTime = "09:00";
        s.endTime = "10:30";
        s.room = "Sala 2b, Centro Extension PUC";
        s.content = "<p></p>";
        s.childsessionID = "1960";
        wList.add(s);

        return wList;
    }

    public ArrayList<Session> loadSessions() {
        ArrayList<Session> sList = new ArrayList<Session>();
        Session s;

        //END FOR Session****************
        s = new Session();
        s.ID = "1910";
        s.name = "Welcome";
        s.date = "Tuesday, Sept.2";
        s.day_id = "2";
        s.beginTime = "09:00";
        s.endTime = "09:15";
        s.room = "N/A";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1920";
        s.name = "Keynote";
        s.date = "Tuesday, Sept.2";
        s.day_id = "2";
        s.beginTime = "09:15";
        s.endTime = "10:30";
        s.room = "Aula Magna";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1921";
        s.name = "Coffee Break";
        s.date = "Tuesday, Sept.2";
        s.day_id = "2";
        s.beginTime = "10:30";
        s.endTime = "11:00";
        s.room = "N/A";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1922";
        s.name = "Session 1 - Friends and connections";
        s.date = "Tuesday, Sept.2";
        s.day_id = "2";
        s.beginTime = "11:00";
        s.endTime = "12:30";
        s.room = "Aula Magna";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1923";
        s.name = "Lunch";
        s.date = "Tuesday, Sept.2";
        s.day_id = "2";
        s.beginTime = "12:30";
        s.endTime = "14:00";
        s.room = "N/A";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1924";
        s.name = "Session 2 - Entities and structures";
        s.date = "Tuesday, Sept.2";
        s.day_id = "2";
        s.beginTime = "14:00";
        s.endTime = "15:30";
        s.room = "Aula Magna";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1925";
        s.name = "Coffee Break";
        s.date = "Tuesday, Sept.2";
        s.day_id = "2";
        s.beginTime = "15:30";
        s.endTime = "16:00";
        s.room = "N/A";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1926";
        s.name = "Session 3 - User experience";
        s.date = "Tuesday, Sept.2";
        s.day_id = "2";
        s.beginTime = "16:00";
        s.endTime = "17:30";
        s.room = "Aula Magna";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1927";
        s.name = "Poster madness";
        s.date = "Tuesday, Sept.2";
        s.day_id = "2";
        s.beginTime = "17:30";
        s.endTime = "18:30";
        s.room = "N/A";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1928";
        s.name = "Poster reception";
        s.date = "Tuesday, Sept.2";
        s.day_id = "2";
        s.beginTime = "18:30";
        s.endTime = "20:30";
        s.room = "On the hallways";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1929";
        s.name = "Keynote";
        s.date = "Wednesday, Sept.3";
        s.day_id = "3";
        s.beginTime = "09:00";
        s.endTime = "10:30";
        s.room = "Aula Magna";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1930";
        s.name = "Coffee Break";
        s.date = "Wednesday, Sept.3";
        s.day_id = "3";
        s.beginTime = "10:30";
        s.endTime = "11:00";
        s.room = "N/A";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1931";
        s.name = "Session 4 - Personalization";
        s.date = "Wednesday, Sept.3";
        s.day_id = "3";
        s.beginTime = "11:00";
        s.endTime = "12:30";
        s.room = "Aula Magna";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1932";
        s.name = "Lunch";
        s.date = "Wednesday, Sept.3";
        s.day_id = "3";
        s.beginTime = "12:30";
        s.endTime = "14:00";
        s.room = "N/A";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1933";
        s.name = "Session 5 - Images and visualizations";
        s.date = "Wednesday, Sept.3";
        s.day_id = "3";
        s.beginTime = "14:00";
        s.endTime = "15:30";
        s.room = "Aula Magna";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1934";
        s.name = "Coffee Break";
        s.date = "Wednesday, Sept.3";
        s.day_id = "3";
        s.beginTime = "15:30";
        s.endTime = "16:00";
        s.room = "N/A";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1935";
        s.name = "Session 6 - Events and conferences";
        s.date = "Wednesday, Sept.3";
        s.day_id = "3";
        s.beginTime = "16:00";
        s.endTime = "17:30";
        s.room = "Aula Magna";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1936";
        s.name = "Session 7 - Skills, interests and identity";
        s.date = "Thursday, Sept.4";
        s.day_id = "4";
        s.beginTime = "09:00";
        s.endTime = "10:30";
        s.room = "Aula Magna";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1937";
        s.name = "Coffee Break";
        s.date = "Thursday, Sept.4";
        s.day_id = "4";
        s.beginTime = "10:30";
        s.endTime = "11:00";
        s.room = "N/A";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1938";
        s.name = "Session 8 - Collaboration and evaluation";
        s.date = "Thursday, Sept.4";
        s.day_id = "4";
        s.beginTime = "11:00";
        s.endTime = "12:30";
        s.room = "Aula Magna";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1939";
        s.name = "Lunch";
        s.date = "Thursday, Sept.4";
        s.day_id = "4";
        s.beginTime = "12:30";
        s.endTime = "14:00";
        s.room = "N/A";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1940";
        s.name = "Session 9 - Crawling, relating and tagging";
        s.date = "Thursday, Sept.4";
        s.day_id = "4";
        s.beginTime = "14:00";
        s.endTime = "15:30";
        s.room = "Aula Magna";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1941";
        s.name = "Closing Creremony";
        s.date = "Thursday, Sept.4";
        s.day_id = "4";
        s.beginTime = "15:30";
        s.endTime = "16:00";
        s.room = "null";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1942";
        s.name = "Doctoral Consortium";
        s.date = "Monday, Sept.1";
        s.day_id = "1";
        s.beginTime = "11:00";
        s.endTime = "12:30";
        s.room = "Sala 2b, Centro Extension PUC";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1943";
        s.name = "Lunch";
        s.date = "Monday, Sept.1";
        s.day_id = "1";
        s.beginTime = "12:30";
        s.endTime = "14:00";
        s.room = "N/A";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1944";
        s.name = "Tutorial 1";
        s.date = "Monday, Sept.1";
        s.day_id = "1";
        s.beginTime = "14:00";
        s.endTime = "15:30";
        s.room = "Sala 2b, Centro Extension PUC";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1945";
        s.name = "Coffee Break";
        s.date = "Monday, Sept.1";
        s.day_id = "1";
        s.beginTime = "15:30";
        s.endTime = "16:00";
        s.room = "N/A";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1946";
        s.name = "Tutorial 2";
        s.date = "Monday, Sept.1";
        s.day_id = "1";
        s.beginTime = "16:00";
        s.endTime = "18:00";
        s.room = "Sala 2b, Centro Extension PUC";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1948";
        s.name = "DataWiz 2014 - Session 1&2";
        s.date = "Monday, Sept.1";
        s.day_id = "1";
        s.beginTime = "11:00";
        s.endTime = "12:30";
        s.room = "Sala 8, Centro Extension PUC";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1949";
        s.name = "DataWiz 2014 - Session 2 - 'Data Interfaces'";
        s.date = "Monday, Sept.1";
        s.day_id = "1";
        s.beginTime = "10:30";
        s.endTime = "12:30";
        s.room = "Sala 8, Centro Extension PUC";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1950";
        s.name = "DataWiz 2014 - Session 3 - 'Data Journalism II'";
        s.date = "Monday, Sept.1";
        s.day_id = "1";
        s.beginTime = "14:00";
        s.endTime = "15:30";
        s.room = "Sala 8, Centro Extension PUC";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1951";
        s.name = "DataWiz 2014 - Session 4 - 'Data Explorations and Exploitations'";
        s.date = "Monday, Sept.1";
        s.day_id = "1";
        s.beginTime = "16:00";
        s.endTime = "18:00";
        s.room = "Sala 8, Centro Extension PUC";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1952";
        s.name = "SP 2014 - Session 1";
        s.date = "Monday, Sept.1";
        s.day_id = "1";
        s.beginTime = "09:00";
        s.endTime = "10:30";
        s.room = "Sala 2a, Centro Extension PUC";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1953";
        s.name = "SP 2014 - Session 2";
        s.date = "Monday, Sept.1";
        s.day_id = "1";
        s.beginTime = "11:00";
        s.endTime = "12:30";
        s.room = "Sala 2a, Centro Extension PUC";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1954";
        s.name = "SP 2014 - Session 3";
        s.date = "Monday, Sept.1";
        s.day_id = "1";
        s.beginTime = "14:00";
        s.endTime = "15:30";
        s.room = "Sala 2a, Centro Extension PUC";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1955";
        s.name = "SP 2014 - Session 4";
        s.date = "Monday, Sept.1";
        s.day_id = "1";
        s.beginTime = "16:00";
        s.endTime = "18:00";
        s.room = "Sala 2a, Centro Extension PUC";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1956";
        s.name = "Coffee Break";
        s.date = "Monday, Sept.1";
        s.day_id = "1";
        s.beginTime = "10:30";
        s.endTime = "11:00";
        s.room = "N/A";
        sList.add(s);

        //END FOR Session****************
        /*s = new Session();
		s.ID = "1957";
		s.name = "Lunch Break";
		s.date = "Monday, Sept.1";
		s.day_id = "1";
		s.beginTime = "12:30";
		s.endTime = "14:00";
		s.room = "null";
		sList.add(s);**/

        //END FOR Session****************
        s = new Session();
        s.ID = "1958";
        s.name = "DataWiz 2014 - Welcome";
        s.date = "Monday, Sept.1";
        s.day_id = "1";
        s.beginTime = "09:00";
        s.endTime = "10:30";
        s.room = "Sala 8, Centro Extension PUC";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1959";
        s.name = "DataWiz 2014 - Conclusion";
        s.date = "Monday, Sept.1";
        s.day_id = "1";
        s.beginTime = "16:30";
        s.endTime = "17:00";
        s.room = "Sala 8, Centro Extension PUC";
        sList.add(s);

        //END FOR Session****************
        s = new Session();
        s.ID = "1960";
        s.name = "LinkQS 2014";
        s.date = "Monday, Sept.1";
        s.day_id = "1";
        s.beginTime = "09:00";
        s.endTime = "10:30";
        s.room = "Sala 2b, Centro Extension PUC";
        sList.add(s);

        //END FOR Session****************


        return sList;


    }
	/*public ArrayList<Paper> loadPapers(){
		ArrayList<Paper> pList = new ArrayList<Paper>();
		Paper p;
		
		
		p = new Paper();
		p.id = "9250";
		p.date = "Wednesday, Sept.3";
		p.day_id = "3";
		p.type = "Full Paper";
		p.belongToSessionID = "1931";
		p.exactbeginTime = "11:00";
		p.exactendTime = "11:30";
		p.presentationID = "6346";
		pList.add(p);

		p = new Paper();
		p.id = "9251";
		p.date = "Thursday, Sept.4";
		p.day_id = "4";
		p.type = "Full Paper";
		p.belongToSessionID = "1936";
		p.exactbeginTime = "09:00";
		p.exactendTime = "09:30";
		p.presentationID = "6347";
		pList.add(p);

		p = new Paper();
		p.id = "9252";
		p.date = "Wednesday, Sept.3";
		p.day_id = "3";
		p.type = "Full Paper";
		p.belongToSessionID = "1933";
		p.exactbeginTime = "14:00";
		p.exactendTime = "14:30";
		p.presentationID = "6348";
		pList.add(p);

		p = new Paper();
		p.id = "9253";
		p.date = "Thursday, Sept.4";
		p.day_id = "4";
		p.type = "Full Paper";
		p.belongToSessionID = "1940";
		p.exactbeginTime = "15:00";
		p.exactendTime = "15:30";
		p.presentationID = "6349";
		pList.add(p);

		p = new Paper();
		p.id = "9254";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Full Paper";
		p.belongToSessionID = "1922";
		p.exactbeginTime = "11:30";
		p.exactendTime = "12:00";
		p.presentationID = "6350";
		pList.add(p);

		p = new Paper();
		p.id = "9255";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Full Paper";
		p.belongToSessionID = "1924";
		p.exactbeginTime = "14:30";
		p.exactendTime = "15:00";
		p.presentationID = "6351";
		pList.add(p);

		p = new Paper();
		p.id = "9256";
		p.date = "Wednesday, Sept.3";
		p.day_id = "3";
		p.type = "Full Paper";
		p.belongToSessionID = "1931";
		p.exactbeginTime = "11:30";
		p.exactendTime = "12:00";
		p.presentationID = "6352";
		pList.add(p);

		p = new Paper();
		p.id = "9257";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Full Paper";
		p.belongToSessionID = "1926";
		p.exactbeginTime = "16:30";
		p.exactendTime = "17:00";
		p.presentationID = "6353";
		pList.add(p);

		p = new Paper();
		p.id = "9258";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Full Paper";
		p.belongToSessionID = "1926";
		p.exactbeginTime = "17:00";
		p.exactendTime = "17:30";
		p.presentationID = "6354";
		pList.add(p);

		p = new Paper();
		p.id = "9259";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Full Paper";
		p.belongToSessionID = "1922";
		p.exactbeginTime = "11:00";
		p.exactendTime = "11:30";
		p.presentationID = "6355";
		pList.add(p);

		p = new Paper();
		p.id = "9260";
		p.date = "Wednesday, Sept.3";
		p.day_id = "3";
		p.type = "Full Paper";
		p.belongToSessionID = "1933";
		p.exactbeginTime = "14:30";
		p.exactendTime = "15:00";
		p.presentationID = "6356";
		pList.add(p);

		p = new Paper();
		p.id = "9261";
		p.date = "Wednesday, Sept.3";
		p.day_id = "3";
		p.type = "Full Paper";
		p.belongToSessionID = "1931";
		p.exactbeginTime = "12:00";
		p.exactendTime = "12:30";
		p.presentationID = "6357";
		pList.add(p);

		p = new Paper();
		p.id = "9262";
		p.date = "Wednesday, Sept.3";
		p.day_id = "3";
		p.type = "Full Paper";
		p.belongToSessionID = "1935";
		p.exactbeginTime = "16:00";
		p.exactendTime = "16:30";
		p.presentationID = "6358";
		pList.add(p);

		p = new Paper();
		p.id = "9263";
		p.date = "Wednesday, Sept.3";
		p.day_id = "3";
		p.type = "Full Paper";
		p.belongToSessionID = "1933";
		p.exactbeginTime = "15:00";
		p.exactendTime = "15:30";
		p.presentationID = "6359";
		pList.add(p);

		p = new Paper();
		p.id = "9264";
		p.date = "Thursday, Sept.4";
		p.day_id = "4";
		p.type = "Full Paper";
		p.belongToSessionID = "1938";
		p.exactbeginTime = "11:30";
		p.exactendTime = "12:00";
		p.presentationID = "6360";
		pList.add(p);

		p = new Paper();
		p.id = "9265";
		p.date = "Thursday, Sept.4";
		p.day_id = "4";
		p.type = "Full Paper";
		p.belongToSessionID = "1940";
		p.exactbeginTime = "14:00";
		p.exactendTime = "14:30";
		p.presentationID = "6361";
		pList.add(p);

		p = new Paper();
		p.id = "9266";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Full Paper";
		p.belongToSessionID = "1924";
		p.exactbeginTime = "14:00";
		p.exactendTime = "14:30";
		p.presentationID = "6362";
		pList.add(p);

		p = new Paper();
		p.id = "9267";
		p.date = "Thursday, Sept.4";
		p.day_id = "4";
		p.type = "Full Paper";
		p.belongToSessionID = "1938";
		p.exactbeginTime = "11:00";
		p.exactendTime = "11:30";
		p.presentationID = "6363";
		pList.add(p);

		p = new Paper();
		p.id = "9268";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Full Paper";
		p.belongToSessionID = "1926";
		p.exactbeginTime = "16:00";
		p.exactendTime = "16:30";
		p.presentationID = "6364";
		pList.add(p);

		p = new Paper();
		p.id = "9269";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Short Paper";
		p.belongToSessionID = "1922";
		p.exactbeginTime = "12:00";
		p.exactendTime = "12:15";
		p.presentationID = "6365";
		pList.add(p);

		p = new Paper();
		p.id = "9270";
		p.date = "Thursday, Sept.4";
		p.day_id = "4";
		p.type = "Short Paper";
		p.belongToSessionID = "1938";
		p.exactbeginTime = "12:00";
		p.exactendTime = "12:15";
		p.presentationID = "6366";
		pList.add(p);

		p = new Paper();
		p.id = "9271";
		p.date = "Thursday, Sept.4";
		p.day_id = "4";
		p.type = "Short Paper";
		p.belongToSessionID = "1936";
		p.exactbeginTime = "10:15";
		p.exactendTime = "10:30";
		p.presentationID = "6367";
		pList.add(p);

		p = new Paper();
		p.id = "9272";
		p.date = "Thursday, Sept.4";
		p.day_id = "4";
		p.type = "Short Paper";
		p.belongToSessionID = "1938";
		p.exactbeginTime = "12:15";
		p.exactendTime = "12:30";
		p.presentationID = "6368";
		pList.add(p);

		p = new Paper();
		p.id = "9273";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Short Paper";
		p.belongToSessionID = "1924";
		p.exactbeginTime = "15:15";
		p.exactendTime = "15:30";
		p.presentationID = "6369";
		pList.add(p);

		p = new Paper();
		p.id = "9274";
		p.date = "Thursday, Sept.4";
		p.day_id = "4";
		p.type = "Short Paper";
		p.belongToSessionID = "1936";
		p.exactbeginTime = "10:00";
		p.exactendTime = "10:15";
		p.presentationID = "6370";
		pList.add(p);

		p = new Paper();
		p.id = "9275";
		p.date = "Thursday, Sept.4";
		p.day_id = "4";
		p.type = "Short Paper";
		p.belongToSessionID = "1936";
		p.exactbeginTime = "09:30";
		p.exactendTime = "09:45";
		p.presentationID = "6371";
		pList.add(p);

		p = new Paper();
		p.id = "9276";
		p.date = "Thursday, Sept.4";
		p.day_id = "4";
		p.type = "Short Paper";
		p.belongToSessionID = "1936";
		p.exactbeginTime = "09:45";
		p.exactendTime = "10:00";
		p.presentationID = "6372";
		pList.add(p);

		p = new Paper();
		p.id = "9277";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Short Paper";
		p.belongToSessionID = "1922";
		p.exactbeginTime = "12:15";
		p.exactendTime = "12:30";
		p.presentationID = "6373";
		pList.add(p);

		p = new Paper();
		p.id = "9278";
		p.date = "Wednesday, Sept.3";
		p.day_id = "3";
		p.type = "Short Paper";
		p.belongToSessionID = "1935";
		p.exactbeginTime = "17:00";
		p.exactendTime = "17:15";
		p.presentationID = "6374";
		pList.add(p);

		p = new Paper();
		p.id = "9279";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Short Paper";
		p.belongToSessionID = "1924";
		p.exactbeginTime = "15:00";
		p.exactendTime = "15:15";
		p.presentationID = "6375";
		pList.add(p);

		p = new Paper();
		p.id = "9280";
		p.date = "Thursday, Sept.4";
		p.day_id = "4";
		p.type = "Short Paper";
		p.belongToSessionID = "1940";
		p.exactbeginTime = "14:45";
		p.exactendTime = "15:00";
		p.presentationID = "6376";
		pList.add(p);

		p = new Paper();
		p.id = "9281";
		p.date = "Thursday, Sept.4";
		p.day_id = "4";
		p.type = "Short Paper";
		p.belongToSessionID = "1940";
		p.exactbeginTime = "14:30";
		p.exactendTime = "14:45";
		p.presentationID = "6377";
		pList.add(p);

		p = new Paper();
		p.id = "9282";
		p.date = "Wednesday, Sept.3";
		p.day_id = "3";
		p.type = "Short Paper";
		p.belongToSessionID = "1935";
		p.exactbeginTime = "16:30";
		p.exactendTime = "16:45";
		p.presentationID = "6378";
		pList.add(p);

		p = new Paper();
		p.id = "9283";
		p.date = "Wednesday, Sept.3";
		p.day_id = "3";
		p.type = "Short Paper";
		p.belongToSessionID = "1935";
		p.exactbeginTime = "16:45";
		p.exactendTime = "17:00";
		p.presentationID = "6379";
		pList.add(p);

		p = new Paper();
		p.id = "9284";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Poster";
		p.belongToSessionID = "1928";
		p.exactbeginTime = "18:30";
		p.exactendTime = "20:30";
		p.presentationID = "6380";
		pList.add(p);

		p = new Paper();
		p.id = "9285";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Poster";
		p.belongToSessionID = "1928";
		p.exactbeginTime = "18:30";
		p.exactendTime = "20:30";
		p.presentationID = "6381";
		pList.add(p);

		p = new Paper();
		p.id = "9286";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Poster";
		p.belongToSessionID = "1928";
		p.exactbeginTime = "18:30";
		p.exactendTime = "20:30";
		p.presentationID = "6382";
		pList.add(p);

		p = new Paper();
		p.id = "9287";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Poster";
		p.belongToSessionID = "1928";
		p.exactbeginTime = "18:30";
		p.exactendTime = "20:30";
		p.presentationID = "6383";
		pList.add(p);

		p = new Paper();
		p.id = "9288";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Poster";
		p.belongToSessionID = "1928";
		p.exactbeginTime = "18:30";
		p.exactendTime = "20:30";
		p.presentationID = "6384";
		pList.add(p);

		p = new Paper();
		p.id = "9289";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Poster";
		p.belongToSessionID = "1928";
		p.exactbeginTime = "18:30";
		p.exactendTime = "20:30";
		p.presentationID = "6385";
		pList.add(p);

		p = new Paper();
		p.id = "9290";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Poster";
		p.belongToSessionID = "1928";
		p.exactbeginTime = "18:30";
		p.exactendTime = "20:30";
		p.presentationID = "6386";
		pList.add(p);

		p = new Paper();
		p.id = "9291";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Poster";
		p.belongToSessionID = "1928";
		p.exactbeginTime = "18:30";
		p.exactendTime = "20:30";
		p.presentationID = "6387";
		pList.add(p);

		p = new Paper();
		p.id = "9292";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Poster";
		p.belongToSessionID = "1928";
		p.exactbeginTime = "18:30";
		p.exactendTime = "20:30";
		p.presentationID = "6388";
		pList.add(p);

		p = new Paper();
		p.id = "9293";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Poster";
		p.belongToSessionID = "1928";
		p.exactbeginTime = "18:30";
		p.exactendTime = "20:30";
		p.presentationID = "6389";
		pList.add(p);

		p = new Paper();
		p.id = "9294";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Poster";
		p.belongToSessionID = "1928";
		p.exactbeginTime = "18:30";
		p.exactendTime = "20:30";
		p.presentationID = "6390";
		pList.add(p);

		p = new Paper();
		p.id = "9295";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Poster";
		p.belongToSessionID = "1928";
		p.exactbeginTime = "18:30";
		p.exactendTime = "20:30";
		p.presentationID = "6391";
		pList.add(p);

		p = new Paper();
		p.id = "9296";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Poster";
		p.belongToSessionID = "1928";
		p.exactbeginTime = "18:30";
		p.exactendTime = "20:30";
		p.presentationID = "6392";
		pList.add(p);

		p = new Paper();
		p.id = "9297";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Poster";
		p.belongToSessionID = "1928";
		p.exactbeginTime = "18:30";
		p.exactendTime = "20:30";
		p.presentationID = "6393";
		pList.add(p);

		p = new Paper();
		p.id = "9298";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Poster";
		p.belongToSessionID = "1928";
		p.exactbeginTime = "18:30";
		p.exactendTime = "20:30";
		p.presentationID = "6394";
		pList.add(p);

		p = new Paper();
		p.id = "9299";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Late-Breaking Results";
		p.belongToSessionID = "1928";
		p.exactbeginTime = "18:30";
		p.exactendTime = "20:30";
		p.presentationID = "6395";
		pList.add(p);

		p = new Paper();
		p.id = "9300";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "Late-Breaking Results";
		p.belongToSessionID = "1928";
		p.exactbeginTime = "18:30";
		p.exactendTime = "20:30";
		p.presentationID = "6396";
		pList.add(p);

		p = new Paper();
		p.id = "9301";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "Doctoral Consortium";
		p.belongToSessionID = "1942";
		p.exactbeginTime = "11:00";
		p.exactendTime = "11:30";
		p.presentationID = "6457";
		pList.add(p);

		p = new Paper();
		p.id = "9302";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "Doctoral Consortium";
		p.belongToSessionID = "1942";
		p.exactbeginTime = "11:30";
		p.exactendTime = "12:00";
		p.presentationID = "6458";
		pList.add(p);

		p = new Paper();
		p.id = "9350";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "no-paper";
		p.belongToSessionID = "1910";
		p.exactbeginTime = "09:00";
		p.exactendTime = "09:15";
		p.presentationID = "6446";
		pList.add(p);

		p = new Paper();
		p.id = "9350";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "no-paper";
		p.belongToSessionID = "1921";
		p.exactbeginTime = "10:30";
		p.exactendTime = "11:00";
		p.presentationID = "6447";
		pList.add(p);

		p = new Paper();
		p.id = "9350";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "no-paper";
		p.belongToSessionID = "1923";
		p.exactbeginTime = "12:30";
		p.exactendTime = "14:00";
		p.presentationID = "6448";
		pList.add(p);

		p = new Paper();
		p.id = "9350";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "no-paper";
		p.belongToSessionID = "1925";
		p.exactbeginTime = "15:30";
		p.exactendTime = "16:00";
		p.presentationID = "6449";
		pList.add(p);

		p = new Paper();
		p.id = "9350";
		p.date = "Tuesday, Sept.2";
		p.day_id = "2";
		p.type = "no-paper";
		p.belongToSessionID = "1927";
		p.exactbeginTime = "17:30";
		p.exactendTime = "18:30";
		p.presentationID = "6450";
		pList.add(p);

		p = new Paper();
		p.id = "9350";
		p.date = "Wednesday, Sept.3";
		p.day_id = "3";
		p.type = "no-paper";
		p.belongToSessionID = "1930";
		p.exactbeginTime = "10:30";
		p.exactendTime = "11:00";
		p.presentationID = "6451";
		pList.add(p);

		p = new Paper();
		p.id = "9350";
		p.date = "Wednesday, Sept.3";
		p.day_id = "3";
		p.type = "no-paper";
		p.belongToSessionID = "1932";
		p.exactbeginTime = "12:30";
		p.exactendTime = "14:00";
		p.presentationID = "6452";
		pList.add(p);

		p = new Paper();
		p.id = "9350";
		p.date = "Wednesday, Sept.3";
		p.day_id = "3";
		p.type = "no-paper";
		p.belongToSessionID = "1934";
		p.exactbeginTime = "15:30";
		p.exactendTime = "16:00";
		p.presentationID = "6453";
		pList.add(p);

		p = new Paper();
		p.id = "9350";
		p.date = "Thursday, Sept.4";
		p.day_id = "4";
		p.type = "no-paper";
		p.belongToSessionID = "1937";
		p.exactbeginTime = "10:30";
		p.exactendTime = "11:00";
		p.presentationID = "6454";
		pList.add(p);

		p = new Paper();
		p.id = "9350";
		p.date = "Thursday, Sept.4";
		p.day_id = "4";
		p.type = "no-paper";
		p.belongToSessionID = "1939";
		p.exactbeginTime = "12:30";
		p.exactendTime = "14:00";
		p.presentationID = "6455";
		pList.add(p);

		p = new Paper();
		p.id = "9350";
		p.date = "Thursday, Sept.4";
		p.day_id = "4";
		p.type = "no-paper";
		p.belongToSessionID = "1941";
		p.exactbeginTime = "15:30";
		p.exactendTime = "16:00";
		p.presentationID = "6456";
		pList.add(p);

		p = new Paper();
		p.id = "9350";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "no-paper";
		p.belongToSessionID = "1943";
		p.exactbeginTime = "12:30";
		p.exactendTime = "14:00";
		p.presentationID = "6459";
		pList.add(p);

		p = new Paper();
		p.id = "9350";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "no-paper";
		p.belongToSessionID = "1945";
		p.exactbeginTime = "15:50";
		p.exactendTime = "16:10";
		p.presentationID = "6461";
		pList.add(p);

		p = new Paper();
		p.id = "9351";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "Tutorial";
		p.belongToSessionID = "1944";
		p.exactbeginTime = "14:00";
		p.exactendTime = "15:50";
		p.presentationID = "6460";
		pList.add(p);

		p = new Paper();
		p.id = "9352";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "Tutorial";
		p.belongToSessionID = "1946";
		p.exactbeginTime = "16:10";
		p.exactendTime = "18:00";
		p.presentationID = "6462";
		pList.add(p);

		p = new Paper();
		p.id = "9465";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "Workshop Paper";
		p.belongToSessionID = "1951";
		p.exactbeginTime = "16:20";
		p.exactendTime = "16:40";
		p.presentationID = "6575";
		pList.add(p);

		p = new Paper();
		p.id = "9466";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "Workshop Paper";
		p.belongToSessionID = "1951";
		p.exactbeginTime = "16:40";
		p.exactendTime = "17:00";
		p.presentationID = "6576";
		pList.add(p);

		p = new Paper();
		p.id = "9467";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "Workshop Paper";
		p.belongToSessionID = "1950";
		p.exactbeginTime = "14:20";
		p.exactendTime = "14:40";
		p.presentationID = "6577";
		pList.add(p);

		p = new Paper();
		p.id = "9468";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "Workshop Paper";
		p.belongToSessionID = "1948";
		p.exactbeginTime = "11:00";
		p.exactendTime = "11:20";
		p.presentationID = "6578";
		pList.add(p);

		p = new Paper();
		p.id = "9469";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "Workshop Paper";
		p.belongToSessionID = "1948";
		p.exactbeginTime = "11:40";
		p.exactendTime = "12:00";
		p.presentationID = "6579";
		pList.add(p);

		p = new Paper();
		p.id = "9470";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "Workshop Paper";
		p.belongToSessionID = "1950";
		p.exactbeginTime = "15:00";
		p.exactendTime = "15:20";
		p.presentationID = "6580";
		pList.add(p);

		p = new Paper();
		p.id = "9471";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "Workshop Paper";
		p.belongToSessionID = "1948";
		p.exactbeginTime = "12:00";
		p.exactendTime = "12:20";
		p.presentationID = "6581";
		pList.add(p);

		p = new Paper();
		p.id = "9472";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "Workshop Paper";
		p.belongToSessionID = "1950";
		p.exactbeginTime = "14:40";
		p.exactendTime = "15:00";
		p.presentationID = "6582";
		pList.add(p);

		p = new Paper();
		p.id = "9473";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "Workshop Paper";
		p.belongToSessionID = "1950";
		p.exactbeginTime = "14:00";
		p.exactendTime = "14:20";
		p.presentationID = "6583";
		pList.add(p);

		p = new Paper();
		p.id = "9474";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "Workshop Paper";
		p.belongToSessionID = "1958";
		p.exactbeginTime = "09:30";
		p.exactendTime = "10:30";
		p.presentationID = "6584";
		pList.add(p);

		p = new Paper();
		p.id = "9476";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "Workshop Paper";
		p.belongToSessionID = "1951";
		p.exactbeginTime = "16:00";
		p.exactendTime = "16:20";
		p.presentationID = "6586";
		pList.add(p);

		p = new Paper();
		p.id = "9484";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "Workshop Paper";
		p.belongToSessionID = "1960";
		p.exactbeginTime = "10:00";
		p.exactendTime = "10:20";
		p.presentationID = "6594";
		pList.add(p);

		p = new Paper();
		p.id = "9485";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "Workshop Paper";
		p.belongToSessionID = "1960";
		p.exactbeginTime = "09:40";
		p.exactendTime = "10:00";
		p.presentationID = "6595";
		pList.add(p);

		p = new Paper();
		p.id = "9486";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "Workshop Paper";
		p.belongToSessionID = "1960";
		p.exactbeginTime = "09:20";
		p.exactendTime = "09:40";
		p.presentationID = "6596";
		pList.add(p);

		p = new Paper();
		p.id = "9487";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "Workshop Paper";
		p.belongToSessionID = "1953";
		p.exactbeginTime = "11:00";
		p.exactendTime = "11:30";
		p.presentationID = "6597";
		pList.add(p);

		p = new Paper();
		p.id = "9488";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "Workshop Paper";
		p.belongToSessionID = "1954";
		p.exactbeginTime = "14:00";
		p.exactendTime = "14:30";
		p.presentationID = "6598";
		pList.add(p);

		p = new Paper();
		p.id = "9489";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "Workshop Paper";
		p.belongToSessionID = "1953";
		p.exactbeginTime = "11:30";
		p.exactendTime = "12:00";
		p.presentationID = "6599";
		pList.add(p);

		p = new Paper();
		p.id = "9490";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "Workshop Paper";
		p.belongToSessionID = "1954";
		p.exactbeginTime = "15:00";
		p.exactendTime = "15:30";
		p.presentationID = "6614";
		pList.add(p);

		p = new Paper();
		p.id = "9491";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "Workshop Paper";
		p.belongToSessionID = "1954";
		p.exactbeginTime = "14:30";
		p.exactendTime = "15:00";
		p.presentationID = "6601";
		pList.add(p);

		p = new Paper();
		p.id = "9492";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "Workshop Paper";
		p.belongToSessionID = "1953";
		p.exactbeginTime = "12:00";
		p.exactendTime = "12:30";
		p.presentationID = "6602";
		pList.add(p);

		p = new Paper();
		p.id = "9494";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "no-paper";
		p.belongToSessionID = "1952";
		p.exactbeginTime = "09:00";
		p.exactendTime = "09:15";
		p.presentationID = "6604";
		pList.add(p);

		p = new Paper();
		p.id = "9494";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "no-paper";
		p.belongToSessionID = "1958";
		p.exactbeginTime = "09:00";
		p.exactendTime = "09:30";
		p.presentationID = "6612";
		pList.add(p);

		p = new Paper();
		p.id = "9494";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "no-paper";
		p.belongToSessionID = "1960";
		p.exactbeginTime = "09:00";
		p.exactendTime = "09:20";
		p.presentationID = "6613";
		pList.add(p);

		p = new Paper();
		p.id = "9495";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "Workshop Paper";
		p.belongToSessionID = "1952";
		p.exactbeginTime = "09:15";
		p.exactendTime = "10:30";
		p.presentationID = "6605";
		pList.add(p);

		p = new Paper();
		p.id = "9496";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "no-paper";
		p.belongToSessionID = "1956";
		p.exactbeginTime = "10:30";
		p.exactendTime = "11:00";
		p.presentationID = "6606";
		pList.add(p);

		p = new Paper();
		p.id = "9496";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "no-paper";
		p.belongToSessionID = "1950";
		p.exactbeginTime = "15:20";
		p.exactendTime = "15:30";
		p.presentationID = "6615";
		pList.add(p);

		p = new Paper();
		p.id = "9496";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "no-paper";
		p.belongToSessionID = "1948";
		p.exactbeginTime = "12:20";
		p.exactendTime = "12:30";
		p.presentationID = "6616";
		pList.add(p);

		p = new Paper();
		p.id = "9496";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "no-paper";
		p.belongToSessionID = "1942";
		p.exactbeginTime = "12:00";
		p.exactendTime = "12:30";
		p.presentationID = "6617";
		pList.add(p);

		p = new Paper();
		p.id = "9496";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "no-paper";
		p.belongToSessionID = "1960";
		p.exactbeginTime = "10:20";
		p.exactendTime = "10:30";
		p.presentationID = "6618";
		pList.add(p);

		p = new Paper();
		p.id = "9496";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "no-paper";
		p.belongToSessionID = "1951";
		p.exactbeginTime = "17:30";
		p.exactendTime = "18:00";
		p.presentationID = "6619";
		pList.add(p);

		p = new Paper();
		p.id = "9496";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "no-paper";
		p.belongToSessionID = "1955";
		p.exactbeginTime = "16:30";
		p.exactendTime = "18:00";
		p.presentationID = "6620";
		pList.add(p);

		p = new Paper();
		p.id = "9497";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "no-paper";
		p.belongToSessionID = "1955";
		p.exactbeginTime = "16:00";
		p.exactendTime = "16:30";
		p.presentationID = "6608";
		pList.add(p);

		p = new Paper();
		p.id = "9498";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "Workshop Paper";
		p.belongToSessionID = "1948";
		p.exactbeginTime = "11:20";
		p.exactendTime = "11:40";
		p.presentationID = "6609";
		pList.add(p);

		p = new Paper();
		p.id = "9499";
		p.date = "Monday, Sept.1";
		p.day_id = "1";
		p.type = "no-paper";
		p.belongToSessionID = "1951";
		p.exactbeginTime = "17:00";
		p.exactendTime = "17:30";
		p.presentationID = "6611";
		pList.add(p);

		//END PAPERS****************

		

		return pList;
	

	}
	public ArrayList<PaperContent> loadPaperContents(){
		ArrayList<PaperContent> pList = new ArrayList<PaperContent>();
		PaperContent p;
		
		//REPLACE WITH BELOW CODES

		p = new PaperContent();
		p.id = "9250";
		p.type = "Full Paper";
		p.authors = "Mohammad Ali Abbasi, Jiliang Tang, Huan Liu";
		p.title = "Scalable Learning of Users' Preferences Using Networked Data";
		p.paperAbstract = "<p style='text-align: justify;'>Users' personal information such as their political views is important for many applications such as targeted advertisement or real-time monitoring of political opinions. Huge amounts of data generated by social media users present opportunities and challenges to studying these preferences in a large scale. In this paper, we aim to infer social media users' political views when only network information is available. In particular, given personal preferences about some of the social media users, how can we infer the preferences of unobserved individuals in the same network? There are many existing solutions that address the problem of classification with networked data problem. However, networks in social media are normally involving millions and even hundreds of millions of nodes, which make the scalability an important problem in inferring personal preferences in social media. To address the scalability issue, we use social influence theory to construct new features based on a combination of local and global structures of the network. Then we use these features to train classifiers and predict users' preferences. Using the entire network information is inefficient for real-world social networks. By extracting local social dimensions, we present an efficient and scalable solution. Further, by capturing the network's global pattern, the proposed solution, balances the performance requirement between accuracy and efficiency.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631796";
		pList.add(p);

		p = new PaperContent();
		p.id = "9251";
		p.type = "Full Paper";
		p.authors = "Sergiu Chelaru, Eelco Herder, Kaweh Djafari Naini, Patrick Siehndel";
		p.title = "Recognizing Skill Networks and Their Specific Communication and Connection Practices";
		p.paperAbstract = "<p style='text-align: justify;'>Social networks are a popular medium for building and maintaining a professional network. Many studies exist on general communication and connection practices within these networks. However, studies on expertise search suggest the existence of subgroups centered around a particular profession. In this paper we analyse commonalities and differences between these groups, based on a set of 94,155 public user profiles. The results confirm that such subgroups can be recognized. Further, the average number of connections differs between groups, as a result of differences in intention for using social media. Similarly, within the groups specific topics and resources are discussed and shared, and there are interesting differences in the tone and wording they use. These insights are relevant for interpreting results from social media analyses and can be used for identifying group-specific resources and communication practices that new members may want to know about.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631801";
		pList.add(p);

		p = new PaperContent();
		p.id = "9252";
		p.type = "Full Paper";
		p.authors = "Emilio Ferrara, Roberto Interdonato, Andrea Tagarelli";
		p.title = "Online Popularity and Topical Interests through the Lens of Instagram";
		p.paperAbstract = "<p style='text-align: justify;'>Online socio-technical systems can be studied as proxy of the real world to investigate human behavior and social interactions at scale. Here we focus on Instagram, a media-sharing online platform whose popularity has been rising up to gathering hundred millions users. Instagram exhibits a mixture of features including social structure, social tagging and media sharing. The network of social interactions among users models various dynamics including follower/followee relations and users' communication by means of posts/comments. Users can upload and tag media such as photos and pictures, and they can ``like'' and comment each piece of information on the platform. In this work we investigate three major aspects on our constructed Instagram dataset: (i) the structural characteristics of its network of heterogeneous interactions, to unveil the emergence of self organization and topically-induced community structure; (ii) the dynamics of content production and consumption, to understand how global trends and popular users emerge; (iii) the behavior of users labeling media with tags, to determine how they devote their attention and to explore the variety of their topical interests. Our analysis provides clues to understand human behavior dynamics on socio-technical systems, specifically users and content popularity, the mechanisms of users' interactions in online environments and how collective trends emerges from individuals' topical interests.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631808";
		pList.add(p);

		p = new PaperContent();
		p.id = "9253";
		p.type = "Full Paper";
		p.authors = "Georges Gouriten, Silviu Maniu, Pierre Senellart";
		p.title = "Scalable, Generic, and Adaptive Systems for Focused Crawling";
		p.paperAbstract = "<p style='text-align: justify;'>Focused crawling is the process of exploring a graph iteratively, focusing on parts of the graph relevant to a given topic. It occurs in many situations such as a company collecting data on competition, a journalist surfing the Web to investigate a political scandal, or an archivist recording the activity of influential Twitter users during a presidential election. In all these applications, users explore a graph (e.g., the Web or a social network), nodes are discovered one by one, the total number of exploration steps is constrained, some nodes are more valuable than others, and the objective is to maximize the total value of the crawled subgraph. In this article, we introduce scalable, generic, and adaptive systems for focused crawling. Our first effort is to define an abstraction of focused crawling applicable to a large domain of real-world scenarios. We then propose a generic algorithm, which allows us to identify and optimize the relevant subsystems. We prove the intractability of finding an optimal exploration, even when all the information is available. Taking this intractability into account, we investigate how the crawler can be steered in several experimental graphs. We show the good performance of a greedy strategy and the importance of being able to run at each step a new estimation of the crawling frontier. We then discuss this estimation through heuristics, self-trained regression, or multi-armed bandits. We eventually investigate their scalability and efficiency in different real-world scenarios and by comparing with state-of-the-art systems.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631795";
		pList.add(p);

		p = new PaperContent();
		p.id = "9254";
		p.type = "Full Paper";
		p.authors = "Jonathan Herzig, Yosi Mass, Haggai Roitman";
		p.title = "An Author-Reader Influence Model for Detecting Topic-based Influencers in Social Media";
		p.paperAbstract = "<p style='text-align: justify;'>This work addresses the problem of detecting topic-based influencers in social media. For that end, we devise a novel behavioral model of authors and readers, where authors try to influence readers by generating attractive content, which is both relevant and unique, and readers can become authors themselves by further citing or referencing content made by other authors. The model is realized by means of a content-based citation graph, where nodes represent authors with their generated content and edges represent reader-to-author citations. To find the top influencers for a given topic, we first profile the content of authors (nodes) and citations (edges) and derive topic-based similarity scores to the topic, which further model the unique and relevant topic interests of users. We then present three different extensions of the Topic-Sensitive PageRank algorithm that exploit the similarity scores to find topic-based influencers. We evaluate our solution on a large real-world dataset that was gathered from Twitter by measuring information diffusion in social networks. We show that, overall, our methods outperform several state-of-the-art methods. This work further serves as an evidence that the topic uniqueness aspect in user interests within social media should be considered for the influencers detection task; this is in comparison to previous works who have solely focused on detecting topic-based influencers using the combination of link structure and topic-relevance.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631804";
		pList.add(p);

		p = new PaperContent();
		p.id = "9255";
		p.type = "Full Paper";
		p.authors = "Ricardo Kawase, Patrick Siehndel, Bernardo Pereira Nunes, Eelco Herder";
		p.title = "Exploiting the Wisdom of the Crowds for Characterizing and Connecting Heterogeneous Resources";
		p.paperAbstract = "<p style='text-align: justify;'>Heterogeneous content is an inherent problem for cross-system search, recommendation and personalization. In this paper we investigate differences in topic coverage and the impact of topics in different kinds of Web services. We use entity extraction and categorization to create 'fingerprints' that allow for meaningful comparison. As a basis taxonomy, we use the 23 main categories of Wikipedia Category Graph, which has been assembled over the years by the wisdom of the crowds. Following a proof of concept of our approach, we analyze differences in topic coverage and topic impact. The results show many differences between Web services like Twitter, Flickr and Delicious, which reflect users' behavior and the usage of each system. The paper concludes with a user study that demonstrates the benefits of fingerprints over traditional textual methods for recommendations of heterogeneous resources.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631797";
		pList.add(p);

		p = new PaperContent();
		p.id = "9256";
		p.type = "Full Paper";
		p.authors = "Kevin Koidl, Owen Conlan, Vincent Wade";
		p.title = "Cross-Site Personalization: Assisting Users in Addressing Information Needs that Span Independently Hosted Websites";
		p.paperAbstract = "<p style='text-align: justify;'>This paper discusses Cross-Site Personalization (CSP) an approach to provide personalized assistance the user in addressing information needs that span independently hosted websites. This is done by seamlessly personalizing the support offered to each individual user as they browse across multiple websites by modeling the user?s interactions and then augmenting information access points, such as links, on each independent website. The Cross-Site Personalization approach is realized as a third-party API offering Personalisation As a Service. The personalized augmentations are provided through module extensions for the Web-based Content Management Systems (WCMS) Drupal. The approach is non-intrusive and does not limit or alter the users information access paradigm via hyperlinks. The design of the API ensures user?s privacy by not disclosing personal browsing information to the websites. Rather, this approach recommends how each website may adapt their information and navigation structures to meet the current user?s needs. Finally, the approach ensures user control and scrutiny. The user can enable/disable the CSP assistance at any time and view any information collected by the service. To evaluate the appropriateness of this approach two use cases are presented. The first use case focuses on CSP in closed and more structured domains, such as those typically seen in enterprise website federations. The second use case addresses open domains, where the user is navigating across websites on the open web.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631798";
		pList.add(p);

		p = new PaperContent();
		p.id = "9257";
		p.type = "Full Paper";
		p.authors = "Spyros Kotoulas, Vanessa Lopez, Marco Luca Sbodio, Martin Stephenson, Pierpaolo Tommasi, Pol Mac Aonghusa";
		p.title = "A Linked Data Approach to Care Coordination";
		p.paperAbstract = "<p style='text-align: justify;'>The success of a society is often judged by its ability to support the most vulnerable. Supporting the most vulnerable individuals is extremely challenging from an information needs perspective, since it requires data from numerous domains and systems, including Social Care, Healthcare, Public Safety and Juridical systems. Information sharing on this scale gives rise to scientific and technical challenges with regard to data representation, access, integration and retrieval granularity. This is a practice-oriented paper presenting a Linked Data-based approach that is uniquely positioned to access and surface information across domains and data sources using a combination of vulnerability indexes and contextual exploration. We apply this approach on a set of enterprise systems from IBM to develop an information sharing architecture and prototype for Care Coordination with a focus on Social Care and Healthcare. We report on expert feedback and user studies that indicate that our approach indeed reduces the time required to gain some business insight while maintaining the flexibility of a Linked Data-based integration approach.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631807";
		pList.add(p);

		p = new PaperContent();
		p.id = "9258";
		p.type = "Full Paper";
		p.authors = "Janette Lehmann, Claudia Muller-Birn, David Laniado, Mounia Lalmas, Andreas Kaltenbrunner";
		p.title = "Readers Preferences and Behavior on Wikipedia";
		p.paperAbstract = "<p style='text-align: justify;'>Wikipedia is a collaboratively-edited online encyclopaedia that relies on thousands of editors to both contribute articles and maintain their quality. Over the last years, research has extensively investigated this group of users while another group of Wikipedia users, the readers, their preferences and their behavior have not been much studied. This paper makes this group and their activities visible and valuable to Wikipedia?s editor community. We carried out a study on two datasets covering a 13-month period to obtain insights on users preferences and reading behavior in Wikipedia. We show that the most read articles do not necessarily correspond to those frequently edited, suggesting some degree of non-alignment between users reading preferences and authors editing preferences. We also identified that popular and often edited articles are read according to four main patterns, and that how an article is read may change over time. We illustrate how this information can provide valuable insights to Wikipedia?s editor community.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631805";
		pList.add(p);

		p = new PaperContent();
		p.id = "9259";
		p.type = "Full Paper";
		p.authors = "Liao Lizi, Jing Jiang, Ee-Peng Lim, Heyan Huang";
		p.title = "A Study of Age Gaps between Online Friends";
		p.paperAbstract = "<p style='text-align: justify;'>User attribute extraction on social media has gain considerable attention, while existing methods are mostly supervised which suffer great difficulty in insufficient gold standard data. In this paper, we validate a strong hypothesis based on homophily and adapt it to ensure the certainty of user attribute we extracted via weakly supervised propagation. Homophily, the theory which states that people who are similar tend to become friends, has been well studied in the setting of online social networks. When we focus on age attribute, based on this theory, online friends tend to have similar age. In this work, we take a step further and study the hypothesis that the age gap between online friends become even smaller in a larger friendship clique. We empirically validate our hypothesis using two real social network data sets. We further design a propagation-based algorithm to predict online users' age, leveraging the clique-based hypothesis. We find that our algorithm can outperform several baselines. We believe that this method could work as a way to enrich sparse data and the hypothesis we validated would shed light on exploring the proximity of other user attributes such as education as well.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631800";
		pList.add(p);

		p = new PaperContent();
		p.id = "9260";
		p.type = "Full Paper";
		p.authors = "Sayooran Nagulendra, Julita Vassileva";
		p.title = "Understanding and Controlling the Filter Bubble through Interactive Visualization: A User Study";
		p.paperAbstract = "<p style='text-align: justify;'>?The filter bubble? is a term popularized by Eli Pariser which refers to people getting encapsulated in streams of data such as news or social network updates that are personalized to their interests. While people need protection from information overload and maybe prefer to see content they feel familiar with and viewpoint that they agree with, there is the danger that important issues that should be of concern for everyone will get filtered away and people will live in ?echo-chambers?, blissfully unaware of reality, and exposure to different views. We have proposed a design of an interactive visualization, which provides the user of a social networking site with awareness of the personalization mechanism (the semantics and the source of the content that is filtered away), and with means to control the filtering mechanism. The visualization has been implemented in a peer-to-peer social network and we present here the results of a qualitative and a quantitative evaluation. The quantitative study with 163 participants demonstrates that the visualization leads to increased users? awareness of the filter bubble, understandability of the filtering mechanism and to a feeling of control over the data stream they are seeing.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631811";
		pList.add(p);

		p = new PaperContent();
		p.id = "9261";
		p.type = "Full Paper";
		p.authors = "Daniele Quercia, Rossano Schifanella, Luca Maria Aiello";
		p.title = "The shortest path to happiness: Recommending beautiful, quiet, and happy routes in the city";
		p.paperAbstract = "<p style='text-align: justify;'>When providing directions to a place, web and mobile mapping services are all able to suggest the shortest route. The goal of this work is to automatically suggest routes that are not only short but also emotionally pleasant. To quantify the extent to which urban locations are pleasant, we use data from a crowd-sourcing platform that shows two street scenes in London (out of hundreds), and a user votes on which one looks more beautiful, quiet, and happy. We consider votes from more than 3.3K individuals and translated them into quantitative measures of location perceptions. We arrange those locations into a graph upon which we learn pleasant routes. Upon a quantitative validation, we find that, compared to the shortest routes, the recommended ones add just a few extra walking minutes but are perceived to be beautiful, quiet, and happy. To test the generality of our approach, we consider Flickr metadata of more than 3.7M pictures in London and 1.3M in Boston, compute proxies for the crowdsourced beauty dimension (the one for which we have collected the most votes), and evaluate those proxies with 30 participants in London and 54 in Boston. These participants have not only rated our recommendations but have also carefully motivated their choices, providing insights for future work.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631799";
		pList.add(p);

		p = new PaperContent();
		p.id = "9262";
		p.type = "Full Paper";
		p.authors = "Xin Shuai, Xiaozhong Liu, Tian Xia, Yuqing Wu, Chun Guo";
		p.title = "Comparing the Pulses of Categorical Hot Events in Twitter and Weibo";
		p.paperAbstract = "<p style='text-align: justify;'>The fragility and interconnectivity of the planet argue compellingly for a greater understanding of how different communities make sense of their world. One of such critical demands relies on comparing the Chinese and the people from the rest of the world (e.g., Americans), where communities' ideological and cultural backgrounds can be significantly different. While traditional studies learn the similarities and differences between these communities via high-cost user studies, in this paper, we propose a much more efficient method to compare different communities by utilizing social media. Specifically, Weibo and Twitter, two largest microblogging systems, are employed to represent the target communities, i.e. China and United States, respectively. Meanwhile, through the analysis of Wikipedia page click log, we identify a set of categorical ``Hot Events'' for one month in 2012, and search those hot events in Weibo and Twitter corpora along with timestamps via information retrieval methods. We further quantitatively and qualitatively compare the users' responses to those events in Twitter and Weibo in terms of three aspects: popularity, temporal dynamic and information diffusion. The comparative results show that although the popularity ranking of those events are very similar, the patterns of temporal dynamic and information diffusion are quite different.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631810";
		pList.add(p);

		p = new PaperContent();
		p.id = "9263";
		p.type = "Full Paper";
		p.authors = "Anna Squicciarini, Cornelia Caragea, Rahul Balakavi";
		p.title = "Analysing images' privacy for the modern Web";
		p.paperAbstract = "<p style='text-align: justify;'>Images are now one of the most common forms of content shared in online user-contributed sites and social Web 2.0 applications. In this paper, we present an extensive study exploring privacy and sharing needs of users' uploaded images. We develop learning models to estimate adequate privacy settings for newly uploaded images, based on carefully selected image-specific features. We focus on two types of image features: visual-content images and tags, and metadata. Within these feature types, we identify the smallest set of features, that by themselves or combined together with others, can perform well in properly predicting the degree of sensitivity of users' images. We consider both the case of privacy settings being simple, as well as the case of more complex privacy options, which users may choose from. Our results show that with few carefully selected features, one may achieve extremely high accuracy, especially with the support of metadata.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631803";
		pList.add(p);

		p = new PaperContent();
		p.id = "9264";
		p.type = "Full Paper";
		p.authors = "Jiliang Tang, Xia Hu, Huan Liu";
		p.title = "Cognitive economy strategies employed during information seeking in a hypermedia environment: A qualitative analysis";
		p.paperAbstract = "<p style='text-align: justify;'>Trust plays an important role in helping online users collect reliable information, and has attracted increasing attention in recent years. We learn from social sciences that, as the conceptual counterpart of trust, distrust could be as important as trust. However, little work exists in studying distrust in social media. What is the relationship between trust and distrust? Can we directly apply methodologies from social sciences to study distrust in social media? In this paper, we design two computational tasks by leveraging machine learning techniques to enable the study of online distrust with social media data. The first task is to predict distrust from only trust, and the second task is to predict trust with distrust. We conduct experiments in real-world social media data. The empirical results of the first task provide concrete evidence to answer the question, ``is distrust the negation of trust?'' while the results of the second task help us figure out how valuable the use of distrust in trust prediction.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631793";
		pList.add(p);

		p = new PaperContent();
		p.id = "9265";
		p.type = "Full Paper";
		p.authors = "Bart Thomee, Gianmarco De Francisci Morales";
		p.title = "Automatic Discovery of Global and Local Equivalence Relationships in Labeled Geo-Spatial Data";
		p.paperAbstract = "<p style='text-align: justify;'>People often use different words and synonyms when referring to the same concept or location. Furthermore these words and their usage vary across culture, language, and place. In this paper we propose a novel algorithmic framework to automatically detect which labels refer to the same concept in labeled spatial data. Our method analyzes the patterns in the spatial distribution of labels to discover equivalence relationships, even those holding between non-synonym labels. We evaluate our proposed technique on a large collection of georeferenced Flickr photos and a semi-automatically constructed ground truth from an existing ontology. Our approach is able to classify equivalent tags with a high accuracy (AUC over $0.90$), as well as providing the geographic extent where the relationship holds.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631794";
		pList.add(p);

		p = new PaperContent();
		p.id = "9266";
		p.type = "Full Paper";
		p.authors = "Ikuya Yamada, Tomotaka Ito, Shinnosuke Usami, Shinsuke Takagi, Hideaki Takeda, Yoshiyasu Takefuji";
		p.title = "Evaluating the Helpfulness of Linked Entities to Readers";
		p.paperAbstract = "<p style='text-align: justify;'>When we encounter an interesting entity (e.g., a person's name or a geographic location) while reading text, we typically search and retrieve relevant information about it. Entity linking (EL) is the task of linking entities in a text to the corresponding entries in a knowledge base, such as Wikipedia. Recently, EL has received considerable attention. EL can be used to enhance a user's text reading experience by streamlining the process of retrieving information on entities. Several EL methods have been proposed, though they tend to extract all of the entities in a document including unnecessary ones for users. Excessive linking of entities can be distracting and degrade the user experience. In this paper, we propose a new method for evaluating the helpfulness of linking entities to users. We address this task using supervised machine-learning with a broad set of features. Experimental results show that our method significantly outperforms baseline methods by approximately 5.7%-12% F1. In addition, we propose an application, Linkify, which enables developers to integrate EL easily into their web sites.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631802";
		pList.add(p);

		p = new PaperContent();
		p.id = "9267";
		p.type = "Full Paper";
		p.authors = "Jie Yang, Claudia Hauff, Alessandro Bozzon, Geert-Jan Houben";
		p.title = "Asking the Right Question in Collaborative Q&A systems";
		p.paperAbstract = "<p style='text-align: justify;'>Collaborative Questions Answering (cQA) platforms are a very popular repository of crowd-generated knowledge. By formulating questions, users express needs that other members of the cQA community try to collaboratively satisfy. Poorly formulated queries are less likely to receive useful responses, thus hindering the overall knowledge generation process. Users are often asked to reformulate their needs, adding specific details, providing examples, or simply clarifying the context of their requests. Formulating of a good question is a task that might require several interactions between the asker and other community members, thus delaying answer time and, possibly, decreasing the interest of the community in the issue. This paper contributes new insights to the study of cQA platforms, and focuses on the editing behaviour of users in Stack Overflow. We identify 8 types of editing actions, and we provide a 2-step approach for the automatic suggestion of the most likely editing action to be performed for a newly created question. We tested our approach in the context of the StackOverflow cQA system, demonstrating how, for given type of editing actions, it is possible to provide highly accurate reformulation suggestions.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631809";
		pList.add(p);

		p = new PaperContent();
		p.id = "9268";
		p.type = "Full Paper";
		p.authors = "Kunpeng Zhang, Siddhartha Bhattacharyya, Sudha Ram";
		p.title = "Empirical Analysis of Implicit Brand Networks on Social Media";
		p.paperAbstract = "<p style='text-align: justify;'>This paper studies characteristics of implicit brand-to-brand network built upon a large amount of user historical activities on social media platforms. It is one of the first studies to our knowledge to comprehensively examine brands by incorporating user-generated social content and the networked information from user interactions. This paper makes several important contributions. We build and normalize a weighted and undirected network representing interactions among users and brands. We then explore network structures using modified network measures to understand their characteristics and implications. As a part of this exploration, we address three important research questions: (1) What does the brand-to-brand network look like? (2) Does an influential brand have a large number of fans? (3) Does an influential brand receive more positive or more negative comments from social users? Experiments conducted with Facebook data show that the influence of a brand has high positive correlation with the size of a brand meaning that an influential brand can attract more fans, but a low negative correlation with the sentiment of comments made by users on that brand, which means that negative comments have a more powerful ability to propagate a brand than positive comments. To process the large-scale datasets and networks, we implement MapReduce-based algorithms.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631806";
		pList.add(p);

		p = new PaperContent();
		p.id = "9269";
		p.type = "Short Paper";
		p.authors = "Mohammad Ali Abbasi";
		p.title = "Am I More Similar to My Followers or Followees? Homophily Effect in Directed Online Social Networks";
		p.paperAbstract = "<p style='text-align: justify;'>Homophily is the formation of social ties between two individuals due to similar characteristics or interests. Based on the homophily effect, it is expected to observe a higher degree of homogeneity among connected than disconnected users. This is the base for many researchers to infer users' profile attribute information based on the users' neighbors who revealed their information. In a directed social network the neighbors can be further divided into followers and followees. In this work, we investigate the homophily in a directed network. We also study if a user's personal preferences can be inferred from those of her connected users; which group between follower's group and followee's group is more effective in inferring personal preference. The findings from this work can raise the awareness of user privacy and help a user better manage her privacy. We conduct our experiments by using a set of more than 5 million Facebook fan pages to infer users' political orientation.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631828";
		pList.add(p);

		p = new PaperContent();
		p.id = "9270";
		p.type = "Short Paper";
		p.authors = "Remy Cazabet, Hideaki Takeda";
		p.title = "Understanding mass cooperation through visualization";
		p.paperAbstract = "<p style='text-align: justify;'>We present a new type of visualization designed to help the understanding of inner mechanisms of mass cooperation. This type of cooperation is ubiquitous nowadays, not only in Online Social Networks, but also in many other situations, such as scientific research on a worldwide scale. Mass coop- eration is also at the source of most complex systems. One problem to which researchers are confronted to when they study such cooperation is to build an intuitive representation of what is happening. Many tools and metrics exist to study the results of the cooperation, but sometimes, these metrics can be misleading if one doesn?t really observe what the co- operation process really looks like. The main proposition of this paper is a visualization of the cooperation flow, which we complete with three other tools, each centered on a spe- cific aspect of the cooperation. The novelty of our approach is to represent the internal structure of the cooperation in a longitudinal perspective. We used three large datasets to test our visualizations. Through examples, we present how one can form a rich understanding of what form the cooper- ation takes in a given context, and how this understanding can help us to formulate hypothesis which can consequently be studied with appropriate tools such as statistical analysis.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631818";
		pList.add(p);

		p = new PaperContent();
		p.id = "9271";
		p.type = "Short Paper";
		p.authors = "Evandro Cunha, Gabriel Magno, Marcos Andre Goncalves, Cesar Nardelli Cambraia, Virgilio Almeida";
		p.title = "How you post is who you are: characterizing Google+ status updates across social groups";
		p.paperAbstract = "<p style='text-align: justify;'>The analysis of user-generated content on the Web provides tools to better understand users' behavior and to the development of improved Web services. Here, we consider a large dataset of Google+ status updates to evaluate linguistic features among members of distinct social groups. Our study reveals that groups hold linguistic particularities - such as a tendency to use professional vocabulary, suggesting that Google+ might be employed, by certain users, for professional activities, or that members do not dissociate from their jobs when interacting in this environment. To illustrate a possible application of our outcomes, we present a classification experiment aiming to infer users' membership to social groups through the analysis of their posts, with satisfactory preliminary results, which can be useful for the improvement of services like personalization and misbehavior identification. Our findings help to understand not only collective peculiarities of online social media users, but also important characteristics of the textual genre post, being one of the first and most comprehensive studies on this topic.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631822";
		pList.add(p);

		p = new PaperContent();
		p.id = "9272";
		p.type = "Short Paper";
		p.authors = "Ujwal Gadiraju, Ricardo Kawase, Stefan Dietze";
		p.title = "A Taxonomy of Microtasks on the Web";
		p.paperAbstract = "<p style='text-align: justify;'>Nowadays, a substantial number of people are turning to crowdsourcing, in order to resolve tasks that require human intervention. Despite a considerable amount of research done in the field of crowdsourcing, existing works fall short when it comes to classifying typically crowdsourced tasks. Understanding the dynamics of the tasks that are crowdsourced and the workers' behaviour, plays a vital role in efficient task-design. In this paper, we propose a two-level classification scheme for tasks, based on an extensive study of 1000 workers on CrowdFlower. In addition, we present insights into certain aspects of crowd behaviour; the task affinity of workers, effort exerted by workers to complete tasks of various types, and their satisfaction with the monetary incentives.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631819";
		pList.add(p);

		p = new PaperContent();
		p.id = "9273";
		p.type = "Short Paper";
		p.authors = "Conor Gaffney, Owen Conlan, Vincent Wade";
		p.title = "AMAS Authoring Tool 2.0: A UX Evaluation";
		p.paperAbstract = "<p style='text-align: justify;'>Adaptive hypermedia has been well documented as being very beneficial in the domain of online education. Authoring adaptive educational hypermedia is however a complex and difficult task. There have been a number of tools developed to address the issue of authoring so as to ease the cognitive load involved in composition. This paper examines two key areas related authoring tool design: hypertext representation and User Experience (UX) design. Both of these are important factors that should be considered when designing hypertext authoring tools. The paper also presents the AMAS Authoring Tool. A new and unique authoring tool that allows non-technical Subject Matter Experts to compose adaptive activity based courses without needing to write code or script in technical languages. The paper includes a description and evaluation of the latest AMAS Authoring Tool prototype, version 2.0, which employs an improved UX style in its design.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631827";
		pList.add(p);

		p = new PaperContent();
		p.id = "9274";
		p.type = "Short Paper";
		p.authors = "Eduardo Graells-Garrido, Mounia Lalmas";
		p.title = "Balancing Diversity to Counter-measure Geographical Centralization in Microblogging Platforms";
		p.paperAbstract = "<p style='text-align: justify;'>In the physical world, centralization is a condition where public policy, media attention and people movement are focused around a unique location. In this paper, we study whether centralization is reflected in the virtual population of microblogging platforms. Because centralized locations are arguably more populated, in both physical and virtual realities, their ``voices'' are expected to be more salient than those from less populated locations, decreasing visibility of less populated locations. Motivated by this scenario, we propose to counter-act geographical centralization by promoting geographical diversity in timelines. As a case study we consider a dataset of Twitter in Chile, in the context of the municipal political elections held in 2012. We estimated betweenness centrality over a graph of geographical interactions from user generated content, and found that indeed centralization occurs. To promote geographical diversity, we: 1) geolocate tweets using content-features that ensure more diversity in text classifiers, and evaluate those classifiers according to their diversity and accuracy; 2) define a two-step information filtering algorithm to ensure diversity in summary timelines of events. Because diversity spans many dimensions, this two-step filtering algorithm ensures geographical diversity after filtering considering general diversity, including topical and author diversity. We evaluate the outcome of our filtering algorithm with users, who perceived timelines from our algorithm as more diverse than popular tweets, and more interesting and informative than those generated with prior work.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631823";
		pList.add(p);

		p = new PaperContent();
		p.id = "9275";
		p.type = "Short Paper";
		p.authors = "Wenyi Huang, Ingmar Weber, Sarah Vieweg";
		p.title = "Inferring Nationalities of Twitter Users and Studying Inter-National Linking";
		p.paperAbstract = "<p style='text-align: justify;'>Twitter user profiles contain rich information which allows us to infer particular attributes of one's identity. Referring to characteristics such as gender, age, and/or nationality are a first step in many studies which seek to describe various phenomena related to computational social science. Often, it is through such attributes that studies of social media that focus on, say, the isolation of foreigners, become possible. However, these aspects of identity are not often clearly stated by social media users, so researchers must turn to other means to ascertain identity categories. We discuss the challenge of nationality detection for Twitter users, using rich features from their profiles. In addition, we look at the effectiveness of different features in identifying Twitter users' nationalities. For the case of a highly diverse country-Qatar-we provide a detailed network analysis with insights into user behaviors and linking preference (or the lack thereof) to other nationalities. Finally, we begin to explore metadata related to the fraction of iPhone users in a certain subgroup. From these analyses, we argue that with a good nationality classifier, we could augment traditional surveys that look at social capital within social media derived from Twitter or other sources.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631825";
		pList.add(p);

		p = new PaperContent();
		p.id = "9276";
		p.type = "Short Paper";
		p.authors = "Suin Kim, Ingmar Weber, Li Wei, Alice Oh";
		p.title = "Sociolinguistic Analysis of Twitter in Multilingual Societies";
		p.paperAbstract = "<p style='text-align: justify;'>The language spoken by a member of a multilingual society is not only a reflection of his culture and heritage, but it can also have implications for their social status, the degree of their integration in society, and it can even be a political statement in its own right. At the societal level, how the language use distribution intertwines with the social network structure has implications for the existence of isolated sub-groups and for social capital overall. The dynamics of language choice as a function of a person's social circle also has implication on which languages will die out and which will dominate. We study this interplay of spoken language and network structure in a number of diverse, multi-lingual societies, using Twitter as a data source. In our analysis, we are particularly interested in the role bilinguals play. Concretely, we attempt to quantify the degree to which these users are the bridge-builders between their monolingual counterpart, while monolingual users cluster together. We revalidate that English is used as a lingua franca in the Twitter network. Also, we reveal users of the native non-English language have higher social status than English users, even in societies where English is one of the official languages, and the language convergence pattern is consistent across the regions. Furthermore, we explore for which topics these users prefer their native language rather than English. To the best of our knowledge, this is the largest sociolinguistic study in a network setting.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631824";
		pList.add(p);

		p = new PaperContent();
		p.id = "9277";
		p.type = "Short Paper";
		p.authors = "Venkata Rama Kiran Garimella, Ingmar Weber";
		p.title = "Co-following on Twitter";
		p.paperAbstract = "<p style='text-align: justify;'>We present an in-depth study of co-following on Twitter based on the observation that two Twitter users whose followers have similar friends are also similar, even though they might not share any direct links or a single mutual follower. We show how this observation contributes to (i) a better understanding of language-agnostic user classification on Twitter, (ii) eliciting opportunities for Computational Social Science, and (iii) improving online marketing by identifying cross-selling opportunities. We start with a machine learning problem of predicting a user's preference among two alternative choices of Twitter friends. We show that co-following information provides strong signals for diverse classification tasks and that these signals persist even when (i) the most discriminative features are removed and (ii) only relatively ?sparse? users with fewer than 152 but more than 43 Twitter friends are considered. Going beyond mere classification performance optimization, we present applications of our methodology to Computational Social Science. Here we confirm stereotypes such as that the country singer Kenny Chesney (@kennychesney) is more popular among @GOP followers, whereas Lady Gaga (@ladygaga) enjoys more support from @TheDemocrats followers. In the domain of marketing we give evidence that celebrity endorsement is reflected in co-following and we demonstrate how our methodology can be used to reveal the audience similarities between Apple and Puma and, less obviously, between Nike and Coca-Cola. Concerning a user?s popularity we find a statistically significant connection between having a more ?average? followership and having more followers than direct rivals. Interestingly, a larger audience also seems to be linked to a less diverse audience in terms of their co-following.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631820";
		pList.add(p);

		p = new PaperContent();
		p.id = "9278";
		p.type = "Short Paper";
		p.authors = "Shamanth Kumar, Xia Hu, Huan Liu";
		p.title = "A Behavior Analytics Approach to Identifying Tweets from Crisis Regions";
		p.paperAbstract = "<p style='text-align: justify;'>The growing popularity of Twitter as an information medium has allowed unprecedented access to first-hand information during crises and mass emergency situations. Due to the sheer volume of information generated during a disaster, a key challenge is to filter tweets from the crisis region so their analysis can be prioritized. In this paper, we introduce the task of identifying whether a tweet is generated from within the crisis region as a decision problem. This problem is challenging due to the fact that only ~1% of all tweets have location information. Existing approaches tackle this problem by predicting the location of tweets by relying upon historical tweets from users. As collecting historical information is not practical during emergency situations, we investigate whether it is possible to determine that a tweet originates from the crisis region from the information contained in the tweet and it's publishing user. Motivated by existing studies on the patterns of Twitter usage during crises and the information broadcasting nature of tweets, we conduct a study of the behavioral characteristics of tweets generated within the crisis region. Using the findings from this study, we propose an approach to detect tweets from a crisis region and demonstrate the effectiveness of our approach through experiments.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631814";
		pList.add(p);

		p = new PaperContent();
		p.id = "9279";
		p.type = "Short Paper";
		p.authors = "Vanessa Lopez, Martin Stephenson, Spyros Kotoulas, Pierpaolo Tommasi";
		p.title = "Finding Mr and Mrs Entity in the City of Knowledge";
		p.paperAbstract = "<p style='text-align: justify;'>More and more urban data is published every day, and consequently, consumers want to take advantage of this body of knowledge. Unfortunately, metadata and schema information around this content is sparse. To effectively fulfill user information needs, systems must be able to capture user intent and context in order to evolve beyond current search and exploration techniques. A Linked Data approach is uniquely positioned to surface information and provide interoperability across a diversity of information sources, from consumer data residing in the original enterprise systems, to relevant open city data in tabular form. We present and evaluate a prototype for contextual knowledge mining that enables federated access and querying of entities across hundreds of enterprise and open datasets pertaining to cities. The proposed system is able to (1) lift raw tabular data into a connected and meaningful structure, contextualized within the Web of Data, and (2) support novel search and exploration tasks, by identifying closely related entities across datasets and models. Our user experiments show how semantics, used to consolidate city information and reuse assets from the Web of Data, improve dataset search and provide users effective means to explore related entities and content to fit their information needs.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631817";
		pList.add(p);

		p = new PaperContent();
		p.id = "9280";
		p.type = "Short Paper";
		p.authors = "Zeinab Noorian, Mohsen Mohkami, Julita Vassileva";
		p.title = "Self-Adaptive Filtering Using PID Feedback Controller in Electronic Commerce";
		p.paperAbstract = "<p style='text-align: justify;'>In the absence of legal authorities and enforcement mechanisms in open e-marketplaces, it is extremely challenging for a user to validate the quality of opinions (i.e. ratings and reviews) of products or services provided by other users (referred as advisers). Rationally, advisers tend to be reluctant to share their truthful experience with others. In this paper, we propose an adaptive incentive mechanism, where advisers are motivated to share their actual experiences with their trustworthy peers (friends/neighbors in the social network) in e-marketplaces (social commerce context), and malicious users will be eventually evacuated from the systems. Both theoretical analysis and experimental results demonstrate the effectiveness of our mechanism in promoting the honesty of users in sharing their past experiences.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631821";
		pList.add(p);

		p = new PaperContent();
		p.id = "9281";
		p.type = "Short Paper";
		p.authors = "Elizeu Santos-Neto, Tatiana Pontes, Jussara Almeida, Matei Ripeanu";
		p.title = "On the Choice of Data Sources to Improve Content Discoverability via Textual Feature Optimization";
		p.paperAbstract = "<p style='text-align: justify;'>Video content abounds on the web. Although viewers may reach video content items via referrals, a large portion of the audience comes from keyword-based search and/or tag-based navigation. Consequently, the textual features of this content (e.g., the title, description, and tags) can directly impact the view count of a particular content item, and ultimately the advertisement generated revenue. More importantly, the textual features can generally be optimized to attract more search traffic. This study makes progress on the problem of automating tag selection for online video content with the goal of increasing viewership. It brings two key insights: first, based on the evidence that existing tags for YouTube videos can be improved by an automated tag recommendation process, even for a sample of well curated movies, it explores the impact of using information mined from repositories created by different production modes (e.g., peer- and expert-produced); second, it performs a preliminary characterization of the factors that impact the quality of the tag recommendation pipeline for different input data sources.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631815";
		pList.add(p);

		p = new PaperContent();
		p.id = "9282";
		p.type = "Short Paper";
		p.authors = "Christoph Scholz, Jens Illig, Martin Atzmueller, Gerd Stumme";
		p.title = "On the Predictability of Talk Attendance at Academic Conferences";
		p.paperAbstract = "<p style='text-align: justify;'>This paper focuses on the prediction of real-world talk attendances at academic conferences with respect to different influence factors. We study the predictability of talk attendances using real-world tracked face-to-face contacts. Furthermore, we investigate and discuss the predictive power of user interests extracted from the users' previous publications. We apply Hybrid Rooted PageRank, a state-of-the-art unsupervised machine learning method that combines information from different sources. Using this method, we analyze and discuss the predictive power of contact and interest networks separately and in combination. We find that contact and similarity networks achieve comparable results, and that combinations of different networks can only to a limited extend help to improve the prediction quality. For our experiments, we analyze the predictability of talk attendance at the ACM Conference on Hypertext and Hypermedia 2011 collected using the conference management system Conferator.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631816";
		pList.add(p);

		p = new PaperContent();
		p.id = "9283";
		p.type = "Short Paper";
		p.authors = "Xidao Wen, Yu-Ru Lin, Christoph Trattner, Denis Parra";
		p.title = "Twitter in Academic Conferences: Usage, Networking and Participation over Time";
		p.paperAbstract = "<p style='text-align: justify;'>Twitter is often regarded as the backchannel of the conference. As the main conference takes place in the classroom setting, attendees and 'virtual attendees' talk about the conference as well on Twitter, introduce new ideas or broadcasting informations. In this paper we analyze the scholars' twitter use of 18 computer science conferences over five years, and find that more people are joining the conference on Twitter but mainly for exchanging the informations each year. While 'people come and people go', we want to understand what keeps people stay with the conference on Twitter. By casting the problem as a classification task, we find that the diversity of the user is one of the most influential factors that contribute to the continuing appearance.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631826";
		pList.add(p);

		p = new PaperContent();
		p.id = "9284";
		p.type = "Poster";
		p.authors = "Ahmad Abdel-Hafez, Yue Xu, Audun Josang";
		p.title = "A Rating Aggregation Method for Generating Product Reputations";
		p.paperAbstract = "<p style='text-align: justify;'>Rating systems are used by many websites, which allow customers to rate available items according to their own experience. Subsequently, reputation models are used to aggregate available ratings in order to generate reputation scores for items. A problem with current reputation models is that they provide solutions to enhance accuracy of sparse datasets only, neglecting the performance of their models over dense datasets. In this paper, we propose a novel reputation model, which generates more accurate reputation scores for items using any dataset; whether it is dense or sparse. Our proposed model is described as a weighted average method, where the weights are generated using the normal distribution. Experiments show promising results for our proposed model over state-of-the-art ones on sparse and dense datasets.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631779";
		pList.add(p);

		p = new PaperContent();
		p.id = "9285";
		p.type = "Poster";
		p.authors = "Swati Agrawal, Ashish Sureka";
		p.title = "A Focused Crawler for Mining Hate and Extremism Promoting Users, Videos and Communities on YouTube";
		p.paperAbstract = "<p style='text-align: justify;'>Online video sharing platforms such as YouTube contains several videos and users promoting hate and extremism. Due to low barrier to publication and anonymity, YouTube is misused as a platform by some users and communities to post negative videos disseminating hatred against a particular religion, country or person. We formulate the problem of identification of such malicious videos as a search problem and present a focused-crawler based approach consisting of various components performing several tasks: search strategy or algorithm, node similarity computation metric, learning from exemplary profiles serving as training data, stopping criterion, node classifier and queue manager. We implement two versions of the focused crawler: best-first search and shark search. We conduct a series of experiments by varying the seed, number of n-grams in the language model based comparer, similarity threshold for the classifier and present the results of the experiments using standard Information Retrieval metrics such as precision, recall and F-measure. The accuracy of the proposed solution on the sample dataset is 69% and 74% for the best-first and shark search respectively. We perform characterization study (by manual and visual inspection) of the anti-India hate and extremism promoting videos retrieved by the focused crawler based on terms present in the title of the videos, YouTube category, average length of videos, content focus and target audience. We present the result of applying Social Network Analysis based measures to extract communities and identify core and influential users.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631776";
		pList.add(p);

		p = new PaperContent();
		p.id = "9286";
		p.type = "Poster";
		p.authors = "Dirk Ahlers";
		p.title = "Spatio-Temporal Quality Issues for Local Search";
		p.paperAbstract = "<p style='text-align: justify;'>Geographic search is routinely used in many services and applications that exploit the availability of Web content that is related to a real world spot, region or object. However, do you trust the location information? Who has not made the experience that the restaurant you went to has just moved to another part of the city or shut down? Spatial search returns spatial results, e.g., extracted entities located in a certain spot or area, but their quality can be difficult to judge. In this paper we discuss and develop issues and features of spatial credibility. We present criteria based on spatial, temporal, and topical indicators that define the credibility of geographic information on Web pages as an additional measurement of spatial relevance.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631792";
		pList.add(p);

		p = new PaperContent();
		p.id = "9287";
		p.type = "Poster";
		p.authors = "Long Cheng, Spyros Kotoulas, Tomas Ward, Georgios Theodoropoulos";
		p.title = "A Two-tier Index Architecture for Fast Processing Large RDF Data over Distributed Memory";
		p.paperAbstract = "<p style='text-align: justify;'>Distributed RDF data management systems become increasingly important with the growth of the Semantic Web. Several indexing methods have been proposed, however, they meet performance bottlenecks on either data loading or querying when processing large amounts of data. In this work, we propose efficient methods for processing RDF using dynamic data re-partitioning to enable rapid analysis of large datasets. Our approach adopts a two-tier index architecture on each computation node: (1) a lightweight primary index, to keep loading times low, and (2) a series of dynamic, multi-level secondary indexes, calculated as a by-product of query execution, to decrease or remove inter-machine data movement for subsequent queries that contain the same graph patterns. In addition, we propose methods to replace some secondary indexes with distributed filters, so as to decrease memory consumption. Experimental results on a commodity cluster of 16 nodes show that our multi-level indexing approach can indeed improve loading speeds by an order of magnitude while remaining competitive in terms of performance. Our system can load a dataset of 1.1 billion triples at a rate of 2.48 million triples per second and provides competitive performance to RDF-3X and 4store.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631789";
		pList.add(p);

		p = new PaperContent();
		p.id = "9288";
		p.type = "Poster";
		p.authors = "Ja-Ryoung Choi, Sung Eun An, Soon Bum Lim";
		p.title = "Spatial Hypertext Modeling for Dynamic Contents Authoring System based on Transclusion";
		p.paperAbstract = "<p style='text-align: justify;'>This paper proposes a web content collecting model to reuse a variety of web contents based on Transclusion. Transclusion is a models for collecting existing web contents and including them into new documents. However, Transclusion lacks consideration of copyright issues and dynamic changes. Therefore, we classified transclusions into three different types based on copyright restrictions: Trans-quotation, Trans-reference and Trans-annotation. Then we displayed transclusions in each different type as spatial hypertext model. Also, we designed RVS(ReVerse Syndication) model for recording tracking information to deal with dynamic changes.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631780";
		pList.add(p);

		p = new PaperContent();
		p.id = "9289";
		p.type = "Poster";
		p.authors = "Dominik Kowald, Emanuel Lacic, Christoph Trattner";
		p.title = "TagRec: Towards A Standardized Tag Recommender Benchmarking Framework";
		p.paperAbstract = "<p style='text-align: justify;'>In this paper, we introduce TagRec, a standardized tag recommender benchmarking framework implemented in Java. The purpose of TagRec is to provide researchers with a framework that supports all steps of the development process of a new tag recommendation algorithm in a reproducible way, including methods for data pre-processing, data modeling, data analysis and recommender evaluation against state-of-the-art baseline approaches. We demonstrate the performance of the algorithms implemented in TagRec in terms of prediction quality and runtime using an extensive evaluation of a real-world folksonomy dataset. Furthermore, TagRec contains two novel tag recommendation approaches based on models derived from human cognition and human memory theories.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631781";
		pList.add(p);

		p = new PaperContent();
		p.id = "9290";
		p.type = "Poster";
		p.authors = "Emanuel Lacic, Dominik Kowald, Christoph Trattner";
		p.title = "SocRecM: A Scalable Social Recommender Engine for Online Marketplaces";
		p.paperAbstract = "<p style='text-align: justify;'>In this paper, we present work-in-progress on SocRecM, a novel social recommendation framework for online marketplaces. We demonstrate that SocRecM is not only easy to integrate with existing Web technologies through a RESTful, scalable and easy-to-extend service-based architecture but also reveal the extent to which various social features and recommendation approaches are useful in an online social marketplace environment.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631783";
		pList.add(p);

		p = new PaperContent();
		p.id = "9291";
		p.type = "Poster";
		p.authors = "Zhe Liu, Ingmar Weber";
		p.title = "Is Twitter a Public Sphere? A Cross-Ideological and Cross-Hierarchical Look";
		p.paperAbstract = "<p style='text-align: justify;'>The rise in popularity of Twitter has led to a debate on its impact on public opinions. The optimists foresee an increase in online participation and democratization due to social media's personal and interactive nature. Cyber-pessimists, on the other hand, explain how social media can lead to selective exposure and can be used as a disguise for those in power to disseminate biased information. To investigate this debate empirically, we evaluate Twitter as a public sphere using four metrics: equality, diversity, reciprocity and quality. Using these measures, we analyze the communication patterns between individuals of different hierarchical levels and ideologies. We do this within the context of three diverse conflicts: Israel-Palestine, US Democrats-Republicans, and FC Barcelona-Real Madrid. In all cases, we collect data around a central pair of Twitter accounts representing the two main parties. Our results show in a quantitative manner that Twitter is not an democratic public sphere and that hierarchical effects are part of the reason why it is not.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631788";
		pList.add(p);

		p = new PaperContent();
		p.id = "9292";
		p.type = "Poster";
		p.authors = "Alejandro Montes García, Paul De Bra, George H. L. Fletcher, Mykola Pechenizkiy";
		p.title = "A DSL Based on CSS for Hypertext Adaptation";
		p.paperAbstract = "<p style='text-align: justify;'>Personalization as offered by Adaptive Hypermedia and Recommender Systems has proven to be effective for tackling the information overload problem. However, the development of Adaptive Web-Based Systems is often cumbersome. In this paper we propose a language to express personalization in web systems that captures current data-driven and expert-driven adaptation techniques. It is desirable that this language be as close as possible to current widespread technologies in web development. Hence, we have chosen to develop a CSS-like language because it supports some of the required tasks for an adaptation language for web systems namely, selection of DOM nodes and rules to apply some adaptation techniques. We also define mechanisms for the selection of users and context based on media queries, because they are commonly used with CSS to change the presentation according to device properties.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631782";
		pList.add(p);

		p = new PaperContent();
		p.id = "9293";
		p.type = "Poster";
		p.authors = "Diego Saez-Trumper";
		p.title = "Fake Tweet Buster: A Webtool to Identify Users Promoting Fake News on Twitter";
		p.paperAbstract = "<p style='text-align: justify;'>We present the ``Fake Tweet Buster (FTB), a web application to identify tweets with fake images and users that are consistently uploading and/or promoting fake information on Twitter. To do that, we mix three techniques: (i) reverse image searching, (ii) user analysis and (iii) a crowd sourcing approach to detected this kind of malicious users on Twitter. Using that information we return a credibility classification for the tweet and the user.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631786";
		pList.add(p);

		p = new PaperContent();
		p.id = "9294";
		p.type = "Poster";
		p.authors = "Umang Sharma, Abhishek Suman, Saswata Shannigrahi";
		p.title = "Inferring Social Ties from Common Activities in Twitter";
		p.paperAbstract = "<p style='text-align: justify;'>We investigate the extent to which we can infer social ties between a pair of users of an online social network Twitter, based on their common activities defined by the number of common celebrity profiles they are following. In this work, we analyze the list of celebrities that a set of Twitter users are following in December 2013 to infer the social ties that existed between these users till July 2009. We use two probabilistic models given by Kossinets et al. [Science, 2006] and Crandall et al. [PNAS, 2010] for this purpose. The model of Kossinets et al. is meant to give an upper bound for the probability of friendship between a pair of users, whereas the model of Crandall et al. is supposed to give an almost accurate estimate of the same. We observe that the model of Kossinets et al. is able to give an upper bound whereas the model given by Crandall et al. is unable to give an almost accurate estimate for our dataset. However, the model by Crandall et. al is observed to provide a correct estimate of the probability of friendship between the users when we consider following a particular type of celebrity profile, e.g. CEO, Author etc., as the activity of a user.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631785";
		pList.add(p);

		p = new PaperContent();
		p.id = "9295";
		p.type = "Poster";
		p.authors = "Julien Subercaze, Christophe Gravier";
		p.title = "FoP: Never-Ending Face Recognition and Data Lifting";
		p.paperAbstract = "<p style='text-align: justify;'>In this demonstration, we present Faces of Politics (FoP), a face detection system from pictures illustrating news articles. The rst iteration of the face recognition model propelling FoP was trained using Freebase data about politicians and their pictures. FoP is a never-ending system: when a new face is recognized, the learned model is updated accordingly. At this step, FoP is also giving data in return to the LoD cloud that fed him in the rst place: it leverages visual knowledge as Linked Data.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631777";
		pList.add(p);

		p = new PaperContent();
		p.id = "9296";
		p.type = "Poster";
		p.authors = "Atsushi Tanaka, Hikaru Takemura, Keishi Tajima";
		p.title = "Why You Follow: A Classification Scheme for Twitter Follow Links";
		p.paperAbstract = "<p style='text-align: justify;'>Because of its flexibility, Twitter is used for various purposes, such as, information publishing/gathering, open discussions, and personal communications. As a result, there are various types of users and various types of follow links. In this paper, we propose a scheme for classifying follow links according to the followers' intention. The scheme consists of the three axes: user-orientation, content-orientation, and mutuality. The combination of these three axes covers all major types of follow links found in the real data or in the literature. We tested several methods of automatically classifying follow links according to our classification scheme, and the results suggest that the type of a follow link does not solely depend on the properties of the followee nor solely depends on the properties of the follower. The results also suggest that the proposed three axes are highly independent of each other.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631790";
		pList.add(p);

		p = new PaperContent();
		p.id = "9297";
		p.type = "Poster";
		p.authors = "Michele Trevisiol, Luca Chiarandini, Ricardo Baeza-Yates";
		p.title = "Buon Appetito - Recommending Personalized Menus";
		p.paperAbstract = "<p style='text-align: justify;'>This paper deals with the problem of menu recommendation, that is, recommending menus that a person is likely to consume at a particular restaurant. This is a novel and challenging case that goes beyond the standard restaurant recommendation problem, since it does not simply consider the overall rating of restaurants, but it considers the opinion of users about each dish and drink they consume. We mined restaurant reviews in order to extract frequent food words (that is, words related to foods and drinks) and we used sentiment analysis applied to each sentence of the reviews in order to compute the individual food preferences. We show that extracting sentiment from sentences provides a better level of granularity than extracting it from the whole review. We then extracted frequent combination of dishes that people enjoy using a variation of the Apriori algorithm. Finally, we propose several recommender systems to study the importance of sentiment for the recommendation task and provide suggestions of menus, that is, sets of dishes.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631784";
		pList.add(p);

		p = new PaperContent();
		p.id = "9298";
		p.type = "Poster";
		p.authors = "Gianluca Tursi, Martina Deplano, Giancarlo Ruffo";
		p.title = "AiRCacher: Virtual Geocaching Powered with Augmented Reality";
		p.paperAbstract = "<p style='text-align: justify;'>Nowadays, smartphones and digital networks are being heavily used as data sources for research on social networks. Our daily experiences, interactions and transactions are recorded thanks to the digital traces that users leave behind their activities, both individual and social. In this work, we describe AiRCacher, a mobile app for virtual geocaching enhanced with Augmented Reality. By following gamication and Game With A Purpose design approaches, users play with the app to hide and seek virtual caches and, as a side effect of their gaming activity, they became like social sensors able to provide geo-located social data. Therefore, the aim of our work is to carry out data analyses about users' outdoor behaviors, by looking for several ndings such as trending places for dierent cache's typologies, and the detection of interesting events emerging from the concentration of caches in specic places.</p>";
		p.contentlink = "http://dx.doi.org/10.1145/2631775.2631778";
		pList.add(p);




		p = new PaperContent();
		p.id = "9299";
		p.type = "Late-Breaking Results";
		p.authors = "Aurelie Brouwers";
		p.title = "Cognitive economy strategies employed during information seeking in a hypermedia environment: A qualitative analysis";
		p.paperAbstract = "<p style='text-align: justify;'>Information search in hypermedia system involves several cognitive resources, which can lead to a cognitive load. We observed the user navigation behavior during information seeking tasks in a hypertext environment. In this paper, we present qualitative results about navigation strategies employed in information seeking in order to reduce the cognitive load caused by the task and the interface.</p>";
		p.contentlink = "http://ceur-ws.org/Vol-1210/LBR_01.pdf";
		pList.add(p);

		p = new PaperContent();
		p.id = "9300";
		p.type = "Late-Breaking Results";
		p.authors = "Luz M Quiroga, Wayne Buente, Leonardo Pina Cabrera";
		p.title = "Social connectedness online / offline. Needs of some vulnerable populations in a digital word. The homeless population case";
		p.paperAbstract = "<p style='text-align: justify;'>We are witness to unprecedented opportunities for information discovery thanks to hypertextual linking and Web technologies. Advantages for citizens are numerous, opening opportunities with a single click. We can not only re-find or discover information but it has become the default media for a rich social networking experience, making possible links among information objects and its producers and consumers. It is becoming our main tool to satisfy basic information needs related to health, housing, job seeking, education, research, entertainment, shopping. Equally or even more important are the possibilities of connectedness offered by social media systems and technologies in terms of peer and or emotional support. Unfortunately these technologies can also increase the inequity for those populations who dont have access to them. Factors that influence access include having network connectivity, equipment (computer, cell phones) and different kinds of literacy (informational, technology & digital literacy).<br/>Our paper discusses the research problem, related studies, methodology and preliminary findings of an ongoing project to better understand the use of computers, mobile phones, and social network sites for social connectedness and support among the homeless. Our goal is to present information that may be used to orient Information and Communications Technologies (ICT) agendas of researchers, government, non -profit, educators, etc.</p>";
		p.contentlink = "null";
		pList.add(p);

		p = new PaperContent();
		p.id = "9301";
		p.type = "Doctoral Consortium";
		p.authors = "Walber Pontes, Patricia Behar, Magda Bercht";
		p.title = "Socio-Affective Module for Recommender of Competency Learning Objects MSA-RECOACOMP: A Study in Development";
		p.paperAbstract = "<p style='text-align: justify;'>This article describes the required parameters for the development of the socio-Affective Module (MSA) of Recommender of learning objects by competencies (RECoaComp)-MSA-RECoaComp. This is intended to recognize the socio -affective aspects in recommending Learning Objects (OAs) skills. The module is being implemented by a multidisciplinary team and is on the prototyping phase. In the first stage were scaled the elements that will support the socio-affective recognition process. Such data will be extracted by MSA-RECoaComp an exisiting environment of distance education and is used at the institution, ROODA more specifically one of its resources, the Affective Map [14], and the Recommender of competency Learning objects (RECoaComp). Thus, this work allows you to understand the functionality of the MSA-RECOACOMP noting the feasibility of the recommendation regarding the OAs filtering skills considering the socio-affective aspects.</p>";
		p.contentlink = "http://ceur-ws.org/Vol-1210/DC_02.pdf";
		pList.add(p);

		p = new PaperContent();
		p.id = "9302";
		p.type = "Doctoral Consortium";
		p.authors = "Daniel Epstein, Eliseo Berni Reategui";
		p.title = "A pedagogical agent with embedded data mining functions to support collaborative writing";
		p.paperAbstract = "<p style='text-align: justify;'>Internet growth has induced the development of a large number of collaborative tools for online writing and information sharing. Educators quickly realized the benefits of such tools for learners, allowing them to work online, to share their knowledge and help each other. Distance learning is a key concept in today's educational research; collaborative learning environments are becoming widespread, being more dynamic and resourceful. However, distance learning also introduced a series of problems, such as high evasion rates resulting from lack of support and personalized feedback. It has also introduced difficulties for educators to follow and reviews students' assignments. Based on this scenario, the work presented here proposes the development of a pedagogical agent supported by an intelligent tutoring system to provide students and teachers with assistance in order to minimize some of these problems. The use of a pedagogical agent allows students to have a constant feedback and guidance based on the identification of problems that may emerge from an online collaborative writing activity. The presence of this agent is intended to help students coordinate their efforts in writing a text collaboratively, and improve their work in terms of coherence. Furthermore, the pedagogical agent is also be able to assist teachers, reporting problems and simplifying their tasks related to the analysis of the work produced by each student. To support our pedagogical agent we propose the use of data mining tools to extract information related to the students' writings, and a recommender system to suggest additional resources.</p>";
		p.contentlink = "http://ceur-ws.org/Vol-1210/DC_01.pdf";
		pList.add(p);

		p = new PaperContent();
		p.id = "9351";
		p.type = "Tutorial";
		p.authors = "Kunpeng Zhang";
		p.title = "Matrix Algorithms in Social Recommendation Systems";
		p.paperAbstract = "<p style='text-align: justify;'>Analyzing various user-generated content on social media platform for intelligent decision-makings has been attracted a lot of academic and industrial attention. This textual and networked information can be represented using matrix in many recommendation systems. In this tutorial, some well known and state-of-the-art matrix operation algorithms will be explained with real-world examples, including singular value decomposition, collaborative filtering, locality sensitive hashing, and iterative shrinkage threshold algorithm for matrix completion. The goal of this tutorial is to help audience learn how to construct a social recommender system using state-of-the-art matrix operation algorithms, including converting and formalizing a recommender system problem from data, understanding the challenges and the characteristics of matrix operation algorithms, and applying existing algorithms to build a practical social recommender system. Audience can improve existing algorithms or even propose novel algorithms for their research projects. This tutorial is expected to open a door for people who are interested in doing research in social recommendation area. It tries to help researchers and engineers understand matrix algorithms in social recommender systems.</p>";
		p.contentlink = "null";
		pList.add(p);

		p = new PaperContent();
		p.id = "9352";
		p.type = "Tutorial";
		p.authors = "Alejandro Bellogin, Alan Said";
		p.title = "Evaluating Recommender Systems: Ensuring Replicability of Evaluation";
		p.paperAbstract = "<p style='text-align: justify;'>Currently, a large amount of recommender systems research is based on comparisons of recommendation algorithm's predictive accuracy: the better the evaluation metrics (higher accuracy scores or lower predictive errors), the better the recommender algorithm. However, it is difficult to put in context and compare the results from a given evaluation of a recommender system, mainly because too many alternatives exist when designing and implementing an evaluation strategy. This tutorial will show how to present evaluation results in a clear and concise manner, while ensuring that the evaluation results are comparable, replicable and unbiased. These insights are not limited to the recommender systems research, but are also valid for experiments with other types of personalized interactions and contextual information. The tutorial will present the main experimental conditions/algorithms/metrics in the recommender systems research. In particular, it will focus on the most common concepts that a practitioner can find in the literature. In such context, there will be presented the main difficulties and limitations that can appear when reporting results from a particular experiment, especially, on reproducing such results in the future. This tutorial aims to gather researchers and practitioners interested in defining clear guidelines for their experimental needs to allow fair comparisons to related work. As a particular focus of interest, the tutorial will address the main datasets and benchmarking frameworks available, and how they can (and should) be used to improve the research being published in the topic to overcome limitations related to the lack of reproduction and reproducibility of the experiments.</p>";
		p.contentlink = "null";
		pList.add(p);

		p = new PaperContent();
		p.id = "9465";
		p.type = "Workshop Paper";
		p.authors = "Remy Cazabet, Takeda Hideaki";
		p.title = "A Visualization Platform For Exploring Cooperation";
		p.paperAbstract = "<p style='text-align: justify;'>In this paper, we present a platform designed to explore visually massive cooperation between individuals. With the increasing importance <br />of the Internet, new types of cooperation are becoming common, in which <br />hundreds, thousands or millions of individuals act together in <br />interaction, and produces content in a decentralized manner. As these <br />processes are happening in real-time and without organization, <br />individuals involved in them often do not have a clear vision of what is<br /> happening, or even which role they play in it. The visualization we <br />propose would allow users to take back the power of understanding the <br />processes to which they participate in. We combine time series <br />visualization, together with custom network visualization, in a way <br />generic enough to adapt to many situations, while offering numerous <br />possibilities.</p>";
		p.contentlink = "http://ceur-ws.org/Vol-1210/datawiz2014_01.pdf";
		pList.add(p);

		p = new PaperContent();
		p.id = "9466";
		p.type = "Workshop Paper";
		p.authors = "Celestini Alessandro, Di Marco Antonio, Totano Giuseppe";
		p.title = "A Data Extraction and Visualization Framework for Information Retrieval Systems";
		p.paperAbstract = "<p style='text-align: justify;'>In recent years we are witnessing a continuous growth in the amount of <br />data that both public and private organizations collect and profit by. <br />Search engines are the most common tool used to retrieve information, <br />and more recently, clustering techniques showed to be an effective tool <br />in helping users to skim query results. The majority of the systems <br />proposed to manage information, provide textual interfaces to explore <br />search results that are not specifically designed to provide an <br />interactive experience to the users.<br />Trying to find a solution to this problem, we focus on how to <br />extract conveniently data from sources of interest, and how to enhance <br />their analysis and consultation through visualization techniques. In <br />this work we present a customizable framework able to acquire, search <br />and interactively visualize data. This framework is built upon a modular<br /> architectural schema and its effectiveness will be illustrated by a <br />prototype implemented for a specific application domain.</p>";
		p.contentlink = "http://ceur-ws.org/Vol-1210/datawiz2014_02.pdf";
		pList.add(p);

		p = new PaperContent();
		p.id = "9467";
		p.type = "Workshop Paper";
		p.authors = "Ferrara Emilio, De Meo Pasquale, Catanese Salvatore, Fiumara Giacomo";
		p.title = "Visualizing criminal networks reconstructed from mobile phone records";
		p.paperAbstract = "<p style='text-align: justify;'>In the fight against the racketeering and terrorism, knowledge about the<br /> structure and the organization of criminal networks is of fundamental <br />importance for both the investigations and the development of efficient <br />strategies to prevent and restrain crimes.<br />Intelligence agencies exploit information obtained from the analysis<br /> of large amounts of heterogeneous data deriving from various <br />informative sources including the records of phone traffic, the social <br />networks, surveillance data, interview data, experiential police data, <br />and police intelligence files, to acquire knowledge about criminal <br />networks and initiate accurate and destabilizing actions.<br />In this context, visual representation techniques coordinate the <br />exploration of the structure of the network together with the metrics of<br />  social network analysis.<br />Nevertheless, the utility of visualization tools may become limited <br />when the dimension and the complexity of the system under analysis <br />grow beyond certain terms.<br />In this paper we show how we employ some interactive visualization <br />techniques to represent criminal and terrorist networks reconstructed <br />from phone traffic data, namely foci, fisheye and geo-mapping network <br />layouts.<br />These methods allow the exploration of the network through animated <br />transitions among visualization models and local enlargement techniques <br />in order to improve the comprehension of interesting areas.<br />By combining the features of the various visualization models it is <br />possible to gain substantial enhancements with respect to classic <br />visualization models, often unreadable in those cases of great <br />complexity of the network.</p>";
		p.contentlink = "http://ceur-ws.org/Vol-1210/datawiz2014_03.pdf";
		pList.add(p);

		p = new PaperContent();
		p.id = "9468";
		p.type = "Workshop Paper";
		p.authors = "Graves Alvaro, Bustos-Jimenez Javier";
		p.title = "Towards Visual Overviews for Open Government Data";
		p.paperAbstract = "<p style='text-align: justify;'>The rise of Open Data initiatives has led to the publication of many <br />datasets from different organizations and governments. These datasets <br />cover a wide range of knowledge domains, from budget to education to <br />health care. However, not all datasets have the quality, granularity or <br />type of information that is relevant to each user. Moreover, in many <br />cases the description or metadata does not specify clearly the content <br />of a dataset, difficulting the exploration of datasets by stakeholders. <br />In this paper we propose the use of dashboards and visualizations as a <br />way to preview the content of datasets for easier exploration. The use <br />of visualizations can provide a rapid way to select or discard datasets <br />based on their content, reducing the potential datasets that a user may <br />need to look in order to get what she needs.</p>";
		p.contentlink = "http://ceur-ws.org/Vol-1210/datawiz2014_04.pdf";
		pList.add(p);

		p = new PaperContent();
		p.id = "9469";
		p.type = "Workshop Paper";
		p.authors = "Honaker James, D'Orazio Vito";
		p.title = "Statistical Modeling by Gesture: A graphical, browser-based statistical interface for data repositories";
		p.paperAbstract = "<p style='text-align: justify;'>We detail our construction of TwoRavens, a graphical user interface for <br />quantitative analysis that allows users at all levels of statistical <br />expertise to explore their data, describe their substantive <br />understanding of the data, and appropriately construct and interpret <br />statistical models. The interface is a browser-based, thin client, with <br />the data remaining in an online repository, and the statistical modeling<br /> occurring on a remote server.  In our implementation, we integrate with<br /> tens of thousands of datasets from the Dataverse repository, and the <br />large library of statistical models available in the Zelig package for <br />the R statistical language.  Our interface is entirely gesture-driven, <br />and so easily used on tablets and phones.  This, in combination with <br />being browser-based, makes data exploration and quantitative reasoning <br />easily portable to the classroom with minimal infrastructure or <br />technology overhead.</p>";
		p.contentlink = "http://ceur-ws.org/Vol-1210/datawiz2014_05.pdf";
		pList.add(p);

		p = new PaperContent();
		p.id = "9470";
		p.type = "Workshop Paper";
		p.authors = "Honorato Johanna, Cypriano Lucas, Goveia Fabio, Carreira Lia";
		p.title = "Color of the street: color as images visualization parameters of twitter pictures from Brazilians Manifestations of 2013";
		p.paperAbstract = "<p style='text-align: justify;'>This paper aims to discuss color as a methodological tool in the <br />analysis of large quantities of images. For this purpose, this paper <br />presents a series of researches done by two data analysis labs, Software<br /> Studies Initiative (EUA) and Labic, the Laboratory of Image and <br />Cyberculture Studies (Brazil), in order to illustrate its different <br />uses. Moreover, this paper shows Labic's recent research on color as a <br />parameter for the analysis of 85.585 images linked to twitter hashtag <br />#vemprarua, an important hashtag related to Brazil's 2013 protests. <br />Thus, this paper highlights the importance of colors as parameters, <br />while identifying issues and contributions to contemporary data science.</p>";
		p.contentlink = "http://ceur-ws.org/Vol-1210/datawiz2014_06.pdf";
		pList.add(p);

		p = new PaperContent();
		p.id = "9471";
		p.type = "Workshop Paper";
		p.authors = "Moro Robert, Daraz Jakub, Bielikova Maria";
		p.title = "Visualization of Gaze Tracking Data for UX Testing on the Web";
		p.paperAbstract = "<p style='text-align: justify;'>Visualizations on the Web can help users to understand complicated and <br />complex concepts. For the purpose of evaluation of their usability, gaze<br /> tracking data represent a valuable source of information. These data <br />are themselves complex, time-varying and in large quantities, thus <br />posing challenges on their manipulation and visualization. We propose an<br /> infrastructure for collection and visualization of the gaze tracking <br />data from dynamic Web applications. Its main purpose is to support <br />researchers in UX testing of their proposed interfaces (and <br />visualizations). In the paper, we provide a user study on the usability <br />of the infrastructure and compare it to existing solutions.</p>";
		p.contentlink = "http://ceur-ws.org/Vol-1210/datawiz2014_08.pdf";
		pList.add(p);

		p = new PaperContent();
		p.id = "9472";
		p.type = "Workshop Paper";
		p.authors = "Regattieri Lorena, Chartier Ryan, Windsor Jennifer, Rockwell Geoffrey";
		p.title = "TweetViz: Following Twitter Hashtags to Support Storytelling in Data journalism";
		p.paperAbstract = "<p style='text-align: justify;'>How can visualizations of massive amounts of information be made more <br />useful for data journalists? The availability of large amounts of <br />publicly available user generated content is opening new opportunities <br />to study social, cultural, and communications phenomenon.  Computer <br />assisted analysis now makes it possible to explore the relationship <br />between nodes and text without having to choose between data size and <br />depth. To create a visualization technique that would allowed us to <br />reveal the network of actors and the main themes hidden in a large <br />dataset, we had to work in a method of inquiry for social sciences. <br />Based on the actor-network theory (ANT) we explored a dataset extracted <br />from Twitter in order to map relationships and indicate new <br />possibilities for journalists by discovering main themes around a <br />hashtag, this way we  interpret a layer of text multiple times, <br />analyzing the nodes in its many attributes. Beyond the boundaries of 140<br /> characters, this approach can succeed as it reproduces and reveals the <br />dynamic connections contained in a collective phenomenon. In the last <br />section, we demonstrate a prototype visualization that reveals behaviors<br /> and discourses within the large sample datasets. We use the D3 <br />visualization library to overlap related links and nodes to produce a <br />comprehensible interactive visualization. Our model is interactive and <br />allows us to identify part and whole pattern relationships constant with<br /> the three principles of information visualization: overview first, zoom<br /> and filter, then details on demand. This paper analyses networks from <br />the perspective of ANT in order to create a visualization ready to <br />support users when telling a story with data.</p>";
		p.contentlink = "http://ceur-ws.org/Vol-1210/datawiz2014_09.pdf";
		pList.add(p);

		p = new PaperContent();
		p.id = "9473";
		p.type = "Workshop Paper";
		p.authors = "Regattieri Lorena, Goveia Fabio, Herkenhoff Gabriel, Malini Fabio Luiz";
		p.title = "MarcoCivil: Visualizing the Civil Rights Framework for the Internet in Brazil";
		p.paperAbstract = "<p style='text-align: justify;'>In this paper, we map the controversy surrounding the Marco Civil da Internet (Civil Framework for the Internet) in Brazil.   Drawing on a Twitter dataset spanning from August 2012 to December 2013, this study uses a series of methods of data mining, processing, and information visualization to produce a historiography of collective actions related to the Marco Civil.  The Twitter conversations we trace in this paper began on October 27, 2009 when the Ministry of Culture in in partnership with the National Education and Research Network (RNP) creates a national campaign through the ?Digital Culture Brasil? platform to discuss the MarcoCivil . The public platform for debates and conversations was the basis for the first draft of the bill with high rate participation of the civil society. The MarcoCivil platform at the ?Digital Culture? website creaed initiatives to spread the discussions online:  a Twitter profile @MarcoCivil  (run by the administrators of the platform) and the MarcoCivil hashtag. To conduct the Marco Civil cartography we chose to work with the messages indexed to the `MarcoCivil hashtag circulating on Twitter. We made this choice for two reasons: first, Twitter has an open API (Application Programming Interface) that makes it possible to collect all posts related to a specific term; second, Twitter was an essential platform for early discussions around the Marco Civil. The first record of the hashtag dates from 2009, when there was a movement to seed the public consultation opened by the federal government in the digital platform. However, it is in 2012 and 2013 that Twitter became the online space in which cyber activists were most vocal. From October 2012 and January 2013 , we collected about 21.997  tweets related Marco Civil, it was then that we noticed the presence of a controversy and a diversity of perspectives in dispute. By visualizing the history of the civil rights framework for the internet in Brazil on Twitter our goal is to demonstrate how the different agents involved in this battle. From telecommunications companies to politicians, our report show how history was made in the field of the internet human rights.</p>";
		p.contentlink = "http://ceur-ws.org/Vol-1210/datawiz2014_10.pdf";
		pList.add(p);

		p = new PaperContent();
		p.id = "9474";
		p.type = "Workshop Paper";
		p.authors = "Reyes-Garcia Everardo";
		p.title = "Explorations in Media Visualization";
		p.paperAbstract = "<p style='text-align: justify;'>In this contribution we explore an emergent approach to data visualization called ?media visualization?. The main characteristic of this practice is to take into account the content of visual media directly as a constituent part of the data visualization project. Media visualization employs and develops image processing techniques. It contributes to current efforts on the design of data visualization such as diagrammatical representations, spatial distribution of elements, combination of colors, or animated behaviors. In this paper we describe ?media visualization?: principles, requirements and related work. We also show some examples of media visualization developed by us within the framework of visual analytics and media art.</p>";
		p.contentlink = "http://ceur-ws.org/Vol-1210/datawiz2014_11.pdf";
		pList.add(p);

		p = new PaperContent();
		p.id = "9476";
		p.type = "Workshop Paper";
		p.authors = "Yousuf Bilal, Conlan Owen";
		p.title = "Constructing Narrative Visualizations as a means of Increasing Learner Engagement";
		p.paperAbstract = "<p style='text-align: justify;'>Increasingly visualization systems are using storytelling to present complex data. However, many approaches neglect enabling users to independently explore details within the story. The research presented in this paper provides an overview of the implementation and discusses the evaluation of a novel framework (VisEN), which aims to allow users to construct narratives containing multiple exploration paths. The narratives are told through dynamically generated visualization techniques, which are personalized for individual end users, and where every visualization technique in the narrative can be further explored. The evaluation described assesses the role personalized visual narratives had in increasing engagement of weaker students with an online database SQL course. It was found that weaker students who regularly interacted with their personalized visual narratives showed an improvement in engagement.</p>";
		p.contentlink = "http://ceur-ws.org/Vol-1210/datawiz2014_13.pdf";
		pList.add(p);

		p = new PaperContent();
		p.id = "9484";
		p.type = "Workshop Paper";
		p.authors = "Federica Cena, Silvia Likavec, Amon Rapp, Martina Deplano, Alessandro Marcengo";
		p.title = "Ontologies for Quantified Self: a semantic approach";
		p.paperAbstract = "<p style='text-align: justify;'>The spreading of devices and applications that allow people to collect personal information opens new opportunities for user modeling (UM). In this new scenario UM together with personal informatics (PI) can offer a new way for self-monitoring that can provide the users with a sophisticated mirror of their behavior, attitudes and habits and their consequences on their life, on the environment and on contexts in which they live in. These new forms of self-reflection and self-knowledge can trigger and motivate the behavior change. In this paper we describe the first step in this direction, focusing on opportunities offered by semantic web ontologies for data integration and reasoning over data for recommendation purposes.</p>";
		p.contentlink = "http://ceur-ws.org/Vol-1210/LQS_01.pdf";
		pList.add(p);

		p = new PaperContent();
		p.id = "9485";
		p.type = "Workshop Paper";
		p.authors = "Faisal Alquaddoomi, Cameron Ketcham, Deborah Estrin";
		p.title = "The Email Analysis Framework: Aiding the Analysis of Personal Natural Language Texts";
		p.paperAbstract = "<p style='text-align: justify;'>Free-form email text streams are a rich, yet seldom-tapped, source of information about an individual's internal state. The difficulty in using this source of information is due par- tially to issues with obtaining and parsing these streams, and the sensitivity of the personal data they may contain. This work presents a framework for allowing a user to au- thorize the acquisition and processing of emails from their Gmail account in order to model the user's use of language. The framework exposes a RESTful HTTPS API for third- party apps to produce personal analytics for the user from their language model, over which the user maintains  ne- grained control by selectively granting access via OAuth2. Candidate applications that consume the language models are discussed, including how they may derive personal ana- lytics from the provided data.</p>";
		p.contentlink = "http://ceur-ws.org/Vol-1210/LQS_02.pdf";
		pList.add(p);

		p = new PaperContent();
		p.id = "9486";
		p.type = "Workshop Paper";
		p.authors = "Timothy Wayne Cook, Luciana Tricai Cavalini";
		p.title = "A Multilevel-Model Driven Social Network for Healthcare Information Exchange";
		p.paperAbstract = "<p style='text-align: justify;'>The management of Big Data in healthcare is challenging due to of the evolutionary nature of healthcare information systems. Information quality issues are caused by top-down enforced data models not fitted to each point-of-care clinical requirements as well as an overall focus on reimbursement. Therefore, healthcare Big Data is a disjointed collection of semantically confused and incomplete data. This paper presents MedWeb, a multilevel model-driven, social network architecture implementation of the Multilevel Healthcare Information Modeling (MLHIM) specifications. MedWeb profiles are patient and provider-specific, semantically rich computational artifacts called Concept Constraint Definitions (CCDs). The set of XML instances produced and validated according to the MedWeb profiles produce Hyperdata, overcoming of the concept of Big Data. Hyperdata is defined as syntactically coherent and semantically interoperable data that can be exchanged between MedWeb applications and legacy systems without ambiguity. The process of creating, validating and querying MedWeb Hyperdata is presented</p>";
		p.contentlink = "http://www.mlhim.org";
		pList.add(p);

		p = new PaperContent();
		p.id = "9487";
		p.type = "Workshop Paper";
		p.authors = "Eduardo Graells-Garrido,  Mounia Lalmas, Ricardo Baeza-Yates";
		p.title = "Sentiment Visualisation Widgets for Exploratory Search";
		p.paperAbstract = "<p style='text-align: justify;'> In this paper we propose using visualisation widgets for exploratory search with sentiment as a facet. Starting from several design goals for depiction of ambivalence in sentiment, two visualization widgets are implemented: scatter plot and parallel coordinates. Those widgets were evaluated in a small-scale usability study with exploratory tasks using Wikipedia as dataset. From qualitative feedback, we found that users are favourable to visual approaches, and from quantitative results we found that users spend more time when using scatter plots. To explain those results, based on individual differences in behaviour we defined two types of users: explorers and achievers. In particular, explorers perceived time spent on a task differently and are more engaged than achievers when using scatter plots. Finally, we discuss the implications of our findings for sentiment-based exploratory search and personalised visualisation interfaces based on individual differences.</p>";
		p.contentlink = "http://ceur-ws.org/Vol-1210/SP2014_03.pdf";
		pList.add(p);

		p = new PaperContent();
		p.id = "9488";
		p.type = "Workshop Paper";
		p.authors = "Paulo Cavalin, Maira Gatti, Claudio Pinhanez";
		p.title = "A System for Personalized Offer by Means of Life Event Detection on Social Media and Entity Matching";
		p.paperAbstract = "<p style='text-align: justify;'>In this paper we present a system for personalized offers based on two main components: a) a hybrid method, combining rules and machine learning, to find users that post life events on social media networks; and b) an entity matching algorithm to find out possible relation between the detected social media users and current clients. The main assumption is that, if one can detect the life events of these users, a personalized offer can be made to them even before they look for a product or service. This system has been implemented on the IBM InfoSphere BigInsights platform to take advantage of the Map/Reduce programming framework for large scale capability, and has been tested on a dataset containing 9 million posts from Twitter. In this set a total of 42K life event post, from 19K different users, has been detected, with an overall accuracy of 89% e precision of about 65% to detect life events. The entity matching of these 19K social media users against an internal database of 1.6M users has returned 983 users, with accuracy of about 90%.</p>";
		p.contentlink = "http://ceur-ws.org/Vol-1210/SP2014_06.pdf";
		pList.add(p);

		p = new PaperContent();
		p.id = "9489";
		p.type = "Workshop Paper";
		p.authors = "Smitashree Choudhury, Dr. Harith Alani";
		p.title = "Personal Life Event Detection from Social Media";
		p.paperAbstract = "<p style='text-align: justify;'>Creating video clips out of personal content from social media is on the rise. MuseumOfMe, Facebook Lookback, and Google Awesome are some popular examples. One core challenge to the creation of such life summaries is the identification of personal events, and their time frame. Such videos can greatly benefit from automatically distinguishing between social media content that is about someone's own wedding from that week, to an old wedding, or to that of a friend. In this paper, we describe our approach for identifying a number of common personal life events from social media content (in this paper we have used Twitter for our test), using multiple feature-based classifiers. Results show that combination of linguistic and social interaction features increases overall classification accuracy of most of the events while some events are relatively more difficult than others (e.g. new born with mean precision of .6 from all three models).</p>";
		p.contentlink = "http://ceur-ws.org/Vol-1210/SP2014_04.pdf";
		pList.add(p);

		p = new PaperContent();
		p.id = "9490";
		p.type = "Workshop Paper";
		p.authors = "Simen Fivelstad Smaaberg, Nafiseh Shabib, John Krogstie.";
		p.title = "A User-Study on Context-aware Group Recommendation for Concerts";
		p.paperAbstract = "<p style='text-align: justify;'>In this paper, we present a prototype of a group recommendation system for concerts. The prototype is context sensitive taken the user's location and time into account when giving recommendations. The prototype implements three algorithms to recommend concerts by taking advantage of what users have listened to before: a collaborative filtering algorithm (K-Nearest Neighbor), a Matrix Factorization algorithm, and a Hybrid approach combining these two. The usability of the prototype was evaluated using the System Usability Scale and a user centered evaluation was performed to evaluate the quality of recommendations. The results from the usability evaluation shows that users generally were satisfied with the usability of the prototype. The results from the Quality Evaluation shows that the K-Nearest Neighbor and Hybrid approach produces satisfactory results whereas the Matrix Factorization implementation is a bit poorer. The users testing the prototype were generally satisfied with the quality of recommendations.</p>";
		p.contentlink = "http://ceur-ws.org/Vol-1210/SP2014_07.pdf";
		pList.add(p);

		p = new PaperContent();
		p.id = "9491";
		p.type = "Workshop Paper";
		p.authors = "Emanuel Lacic, Dominik Kowald, Paul Seitlinger,  Christoph Trattner , Denis Parra";
		p.title = "Recommending Items in Social Tagging Systems Using Tag and Time Information";
		p.paperAbstract = "<p style='text-align: justify;'>In this work we present a novel item recommendation approach that aims at improving Collaborative Filtering (CF) in social tagging systems using the information about tags and time. Our algorithm follows a two-step approach, where in the first step a potentially interesting candidate item-set is found using user-based CF and in the second step this candidate item-set is ranked using item-based CF. Within this ranking step we integrate the information of tag usage and time using the Base-Level Learning (BLL) equation coming from human memory theory that is used to determine the reuse-probability of words and tags using a power-law forgetting function.As the results of our extensive evaluation conducted on data-sets gathered from three social tagging systems (BibSonomy, CiteULike and MovieLens) show, the usage of tag-based and time information via the BLL equation also helps to improve the ranking and recommendation process of items and thus, can be used to realize an effective item recommender that outperforms two alternative algorithms which also exploit time and tag-based information.</p>";
		p.contentlink = "http://ceur-ws.org/Vol-1210/SP2014_01.pdf";
		pList.add(p);

		p = new PaperContent();
		p.id = "9492";
		p.type = "Workshop Paper";
		p.authors = "Augusto Queiroz de Macedo, Leandro Balby Marinho";
		p.title = "Event Recommendation in Event-based Social Networks";
		p.paperAbstract = "<p style='text-align: justify;'> With the large number of events published all the time in event-based social networks (EBSN), it has become increasingly difficult for users to find the events that best match their preferences. Recommender systems appear as a natural solution to this problem. However, the event recommendation scenario is quite different from typical recommendation domains (e.g. movies), since there is an intrinsic new item problem involved (i.e. events can not be consumed before their occurrence) and scarce collaborative information. Although some few works have appeared in this area, there is still lacking in the literature an extensive analysis of the different characteristics of EBSN data that can affect the design of event recommenders. In this paper we provide a contribution in this direction, where we investigate and discuss important features of EBSN such as sparsity, events life time, co-participation of users in events and geographic features. We also shed some light on the performance and limitations of several well known recommendation algorithms and combinations of them on real data collected from meetup.com.</p>";
		p.contentlink = "http://ceur-ws.org/Vol-1210/SP2014_02.pdf";
		pList.add(p);

		p = new PaperContent();
		p.id = "9495";
		p.type = "Workshop Paper";
		p.authors = "Luca Aiello";
		p.title = "Nuanced graph representation to improve recommendation: the case of browsing and social networks";
		p.paperAbstract = "<p style='text-align: justify;'>Graphs are ubiquitous representations of a wide range of online traces generated by user activities including browsing, messaging, social linking, and many more. For their simplicity and power, graphs (like other similar representations of relational data) have been used in a plethora of applications, most of them falling under the umbrella of recommendation and personalization. However, very often the notion of graph and its atomic components (nodes and edges) are adopted uncritically, without giving much thought to their nature or meaning. In real-world scenarios the meaning of a link can vary broadly even within the same system or interaction type. We study browsing and social graph and show how a to obtain a more nuanced representation of their links to help gaining a deeper understanding of their nature and, in turn, to properly exploit the information about link type in recommendation tasks. First, we present the use of the BrowseGraph and its decomposition into ReferrerGraphs for image and news recommendation. Last, we will show how conversation graphs can be decomposed in subgraphs carrying different information about the type of resources exchanged between peers, providing an overview on the potential that such nuanced representation can have in the field of recommendation. Our analysis is conducted on large datasets extracted from Yahoo News, Flickr, and aNobii.</p>";
		p.contentlink = "null";
		pList.add(p);

		p = new PaperContent();
		p.id = "9498";
		p.type = "Workshop Paper";
		p.authors = "Medeiros Jean Maicon, Regattieri Lorena, Malini Fabio Luiz";
		p.title = "The use of modularity algorithms as part of the conceptualization of the perspectival form in large networks";
		p.paperAbstract = "<p style='text-align: justify;'>How can we identify perspectives in large networks through the application of modularity algorithms? In the digital humanities [1][2], there is a fair number of scholarly work exploring computational routines to cluster and analyze enormous amounts of data. Recently, social data became a valuable source to study collective phenomenon, they provide the means to comprehend human collectivity by using graph network analysis. In this paper, we describe our approach on the manner of post-social anthropology [3] and social sciences using technical methods: quantitative analysis and modularity optimization. The computational turn is part of the ongoing process to conceptualize the 'perspectival form', as the other would be the semantic analysis of the qualitative data. This technique uses a python script to extract the co-occurrence hashtags network from a Twitter dataset in order to apply in the context of the open-source software Gephi. Our experiments successfully exhibit how social networks can be unfolded when submitting a sample dataset of hashtags to the procedure found in the critical dimension of computational models. Therefore, it discovers the flow of perspectives when the strategy is follow in new workspaces, creating then categories that reveals points of view underneath the controversy. Concluding, this study presents a theoretical and methodological framework based in the post-structuralists, a composition that aims to support studies in different fields of social sciences and humanities.</p>";
		p.contentlink = "http://ceur-ws.org/Vol-1210/datawiz2014_07.pdf";
		pList.add(p);


		

	
		return pList;
	}*/

}


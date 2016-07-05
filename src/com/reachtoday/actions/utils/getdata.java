package com.reachtoday.actions.utils;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;

/** 
 * Servlet implementation class SendNumber
 */

public class getdata extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getdata() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JSONArray tt=new  JSONArray();
		try {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			/*URL urldemo = new URL("http://hub-icd10.glaceemr.com/DataGateway/search?keyword=asthma&targetsystem=icd10");
	        URLConnection yc = urldemo.openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));*/
//	        String inputLine="[{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Unspecified asthma with status asthmaticus\",\"parent\":\"J45^Asthma|J45.9^Other and unspecified asthma|J45.90^Unspecified asthma\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J45.902\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Mild intermittent asthma with status asthmaticus\",\"parent\":\"J45^Asthma|J45.2^Mild intermittent asthma\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J45.22\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Mild intermittent asthma, uncomplicated\",\"parent\":\"J45^Asthma|J45.2^Mild intermittent asthma\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J45.20\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Mild intermittent asthma with (acute) exacerbation\",\"parent\":\"J45^Asthma|J45.2^Mild intermittent asthma\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J45.21\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Mild persistent asthma with status asthmaticus\",\"parent\":\"J45^Asthma|J45.3^Mild persistent asthma\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J45.32\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Unspecified asthma, uncomplicated\",\"parent\":\"J45^Asthma|J45.9^Other and unspecified asthma|J45.90^Unspecified asthma\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J45.909\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Mild persistent asthma, uncomplicated\",\"parent\":\"J45^Asthma|J45.3^Mild persistent asthma\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J45.30\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Mild persistent asthma with (acute) exacerbation\",\"parent\":\"J45^Asthma|J45.3^Mild persistent asthma\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J45.31\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Moderate persistent asthma with status asthmaticus\",\"parent\":\"J45^Asthma|J45.4^Moderate persistent asthma\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J45.42\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Unspecified asthma with (acute) exacerbation\",\"parent\":\"J45^Asthma|J45.9^Other and unspecified asthma|J45.90^Unspecified asthma\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J45.901\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Moderate persistent asthma, uncomplicated\",\"parent\":\"J45^Asthma|J45.4^Moderate persistent asthma\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J45.40\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Moderate persistent asthma with (acute) exacerbation\",\"parent\":\"J45^Asthma|J45.4^Moderate persistent asthma\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J45.41\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Severe persistent asthma with status asthmaticus\",\"parent\":\"J45^Asthma|J45.5^Severe persistent asthma\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J45.52\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Severe persistent asthma, uncomplicated\",\"parent\":\"J45^Asthma|J45.5^Severe persistent asthma\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J45.50\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Severe persistent asthma with (acute) exacerbation\",\"parent\":\"J45^Asthma|J45.5^Severe persistent asthma\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J45.51\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Other asthma\",\"parent\":\"J45^Asthma|J45.9^Other and unspecified asthma|J45.99^Other asthma\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J45.998\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Cough variant asthma\",\"parent\":\"J45^Asthma|J45.9^Other and unspecified asthma|J45.99^Other asthma\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J45.991\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Exercise induced bronchospasm\",\"parent\":\"J45^Asthma|J45.9^Other and unspecified asthma|J45.99^Other asthma\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J45.990\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Pneumoconiosis due to other dust containing silica\",\"parent\":\"J62^Pneumoconiosis due to dust containing silica\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J62.8\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Chronic obstructive pulmonary disease, unspecified\",\"parent\":\"J44^Other chronic obstructive pulmonary disease\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J44.9\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Left ventricular failure\",\"parent\":\"I50^Heart failure\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"I50.1\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Chronic obstructive pulmonary disease with (acute) exacerbation\",\"parent\":\"J44^Other chronic obstructive pulmonary disease\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J44.1\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Chronic obstructive pulmonary disease with acute lower respiratory infection\",\"parent\":\"J44^Other chronic obstructive pulmonary disease\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J44.0\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Hypersensitivity pneumonitis due to other organic dusts\",\"parent\":\"J67^Hypersensitivity pneumonitis due to organic dust\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J67.8\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Pulmonary eosinophilia, not elsewhere classified\",\"parent\":\"\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J82\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Coalworker's pneumoconiosis\",\"parent\":\"\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J60\",\"ageGroup\":\"2\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Laryngeal spasm\",\"parent\":\"J38^Diseases of vocal cords and larynx, not elsewhere classified\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J38.5\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Pneumonitis due to inhalation of other solids and liquids\",\"parent\":\"J69^Pneumonitis due to solids and liquids\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J69.8\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Other diseases of thymus\",\"parent\":\"E32^Diseases of thymus\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E32.8\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"true\",\"manifestationCode\":\"false\",\"description\":\"Family history of asthma and other chronic lower respiratory diseases\",\"parent\":\"Z82^Family history of certain disabilities and chronic diseases (leading to disablement)\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"Z82.5\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"true\",\"description\":\"Psychological and behavioral factors associated with disorders or diseases classified elsewhere\",\"parent\":\"\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"F54\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Other acute and subacute respiratory conditions due to chemicals, gases, fumes and vapors\",\"parent\":\"J68^Respiratory conditions due to inhalation of chemicals, gases, fumes and vapors\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J68.3\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Unspecified pneumoconiosis\",\"parent\":\"\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J64\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Unspecified respiratory condition due to chemicals, gases, fumes and vapors\",\"parent\":\"J68^Respiratory conditions due to inhalation of chemicals, gases, fumes and vapors\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J68.9\",\"ageGroup\":\"-1\"}]";
//String inputLine="[{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Spotted fever due to Rickettsia conorii\",\"parent\":\"A77^Spotted fever [tick-borne rickettsioses]\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A77.1\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Spotted fever due to Rickettsia rickettsii\",\"parent\":\"A77^Spotted fever [tick-borne rickettsioses]\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A77.0\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Fever, unspecified\",\"parent\":\"R50^Fever of other and unknown origin\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"R50.9\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Hemorrhagic fever with renal syndrome\",\"parent\":\"A98^Other viral hemorrhagic fevers, not elsewhere classified\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A98.5\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Trench fever\",\"parent\":\"A79^Other rickettsioses\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A79.0\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Tick-borne relapsing fever\",\"parent\":\"A68^Relapsing fevers\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A68.1\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Sandfly fever\",\"parent\":\"A93^Other arthropod-borne viral fevers, not elsewhere classified\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A93.1\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Dengue hemorrhagic fever\",\"parent\":\"\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A91\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Q fever\",\"parent\":\"\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A78\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Typhus fever due to Rickettsia tsutsugamushi\",\"parent\":\"A75^Typhus fever\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A75.3\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Other specified mosquito-borne viral fevers\",\"parent\":\"A92^Other mosquito-borne viral fevers\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A92.8\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Plasmodium falciparum malaria, unspecified\",\"parent\":\"B50^Plasmodium falciparum malaria\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"B50.9\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Other specified arthropod-borne viral fevers\",\"parent\":\"A93^Other arthropod-borne viral fevers, not elsewhere classified\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A93.8\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Other severe and complicated Plasmodium falciparum malaria\",\"parent\":\"B50^Plasmodium falciparum malaria\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"B50.8\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Colorado tick fever\",\"parent\":\"A93^Other arthropod-borne viral fevers, not elsewhere classified\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A93.2\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Typhoid fever with other complications\",\"parent\":\"A01^Typhoid and paratyphoid fevers|A01.0^Typhoid fever\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A01.09\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Typhus fever due to Rickettsia typhi\",\"parent\":\"A75^Typhus fever\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A75.2\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Streptobacillosis\",\"parent\":\"A25^Rat-bite fevers\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A25.1\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Louse-borne relapsing fever\",\"parent\":\"A68^Relapsing fevers\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A68.0\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Allergic rhinitis due to pollen\",\"parent\":\"J30^Vasomotor and allergic rhinitis\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"J30.1\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Epidemic louse-borne typhus fever due to Rickettsia prowazekii\",\"parent\":\"A75^Typhus fever\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A75.0\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Crimean-Congo hemorrhagic fever\",\"parent\":\"A98^Other viral hemorrhagic fevers, not elsewhere classified\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A98.0\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Sylvatic yellow fever\",\"parent\":\"A95^Yellow fever\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A95.0\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Typhus fever, unspecified\",\"parent\":\"A75^Typhus fever\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A75.9\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Dengue fever [classical dengue]\",\"parent\":\"\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A90\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Relapsing fever, unspecified\",\"parent\":\"A68^Relapsing fevers\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A68.9\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Unspecified malaria\",\"parent\":\"\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"B54\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Machupo hemorrhagic fever\",\"parent\":\"A96^Arenaviral hemorrhagic fever\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A96.1\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Typhoid fever, unspecified\",\"parent\":\"A01^Typhoid and paratyphoid fevers|A01.0^Typhoid fever\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A01.00\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Spotted fever due to Rickettsia siberica\",\"parent\":\"A77^Spotted fever [tick-borne rickettsioses]\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A77.2\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Junin hemorrhagic fever\",\"parent\":\"A96^Arenaviral hemorrhagic fever\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A96.0\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"West Nile virus infection with other neurologic manifestation\",\"parent\":\"A92^Other mosquito-borne viral fevers|A92.3^West Nile virus infection\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A92.32\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Rheumatic myocarditis\",\"parent\":\"I09^Other rheumatic heart diseases\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"I09.0\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Unspecified arthropod-borne viral fever\",\"parent\":\"\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A94\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Drug induced fever\",\"parent\":\"R50^Fever of other and unknown origin\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"R50.2\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Typhoid fever with heart involvement\",\"parent\":\"A01^Typhoid and paratyphoid fevers|A01.0^Typhoid fever\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A01.02\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Postvaccination fever\",\"parent\":\"R50^Fever of other and unknown origin|R50.8^Other specified fever\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"R50.83\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"West Nile virus infection, unspecified\",\"parent\":\"A92^Other mosquito-borne viral fevers|A92.3^West Nile virus infection\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A92.30\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Scarlet fever, uncomplicated\",\"parent\":\"A38^Scarlet fever\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A38.9\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Spotted fever due to Rickettsia australis\",\"parent\":\"A77^Spotted fever [tick-borne rickettsioses]\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A77.3\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Non-neuropathic heredofamilial amyloidosis\",\"parent\":\"E85^Amyloidosis\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E85.0\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"true\",\"manifestationCode\":\"false\",\"description\":\"Encounter for screening for other viral diseases\",\"parent\":\"Z11^Encounter for screening for infectious and parasitic diseases|Z11.5^Encounter for screening for other viral diseases\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"Z11.59\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Other specified rheumatic heart diseases\",\"parent\":\"I09^Other rheumatic heart diseases|I09.8^Other specified rheumatic heart diseases\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"I09.89\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Omsk hemorrhagic fever\",\"parent\":\"A98^Other viral hemorrhagic fevers, not elsewhere classified\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A98.1\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Typhoid pneumonia\",\"parent\":\"A01^Typhoid and paratyphoid fevers|A01.0^Typhoid fever\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A01.03\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Paratyphoid fever, unspecified\",\"parent\":\"A01^Typhoid and paratyphoid fevers\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A01.4\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Visceral leishmaniasis\",\"parent\":\"B55^Leishmaniasis\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"B55.0\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Acute pulmonary coccidioidomycosis\",\"parent\":\"B38^Coccidioidomycosis\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"B38.0\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Lassa fever\",\"parent\":\"A96^Arenaviral hemorrhagic fever\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"A96.2\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Other acute rheumatic heart disease\",\"parent\":\"I01^Rheumatic fever with heart involvement\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"I01.8\",\"ageGroup\":\"-1\"}]";
String inputLine="[{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Type 2 diabetes mellitus without complications\",\"parent\":\"E11^Type 2 diabetes mellitus\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E11.9\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Type 2 diabetes mellitus with diabetic nephropathy\",\"parent\":\"E11^Type 2 diabetes mellitus|E11.2^Type 2 diabetes mellitus with kidney complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E11.21\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Type 2 diabetes mellitus with diabetic polyneuropathy\",\"parent\":\"E11^Type 2 diabetes mellitus|E11.4^Type 2 diabetes mellitus with neurological complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E11.42\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Type 2 diabetes mellitus with diabetic chronic kidney disease\",\"parent\":\"E11^Type 2 diabetes mellitus|E11.2^Type 2 diabetes mellitus with kidney complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E11.22\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Type 1 diabetes mellitus with diabetic nephropathy\",\"parent\":\"E10^Type 1 diabetes mellitus|E10.2^Type 1 diabetes mellitus with kidney complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E10.21\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Other specified diabetes mellitus with diabetic nephropathy\",\"parent\":\"E13^Other specified diabetes mellitus|E13.2^Other specified diabetes mellitus with kidney complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E13.21\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Type 2 diabetes mellitus with mild nonproliferative diabetic retinopathy without macular edema\",\"parent\":\"E11^Type 2 diabetes mellitus|E11.3^Type 2 diabetes mellitus with ophthalmic complications|E11.32^Type 2 diabetes mellitus with mild nonproliferative diabetic retinopathy\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E11.329\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Type 2 diabetes mellitus with hyperglycemia\",\"parent\":\"E11^Type 2 diabetes mellitus|E11.6^Type 2 diabetes mellitus with other specified complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E11.65\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Drug or chemical induced diabetes mellitus with diabetic nephropathy\",\"parent\":\"E09^Drug or chemical induced diabetes mellitus|E09.2^Drug or chemical induced diabetes mellitus with kidney complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E09.21\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Type 2 diabetes mellitus with hypoglycemia without coma\",\"parent\":\"E11^Type 2 diabetes mellitus|E11.6^Type 2 diabetes mellitus with other specified complications|E11.64^Type 2 diabetes mellitus with hypoglycemia\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E11.649\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Diabetes mellitus due to underlying condition with diabetic nephropathy\",\"parent\":\"E08^Diabetes mellitus due to underlying condition|E08.2^Diabetes mellitus due to underlying condition with kidney complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E08.21\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Type 2 diabetes mellitus with other diabetic kidney complication\",\"parent\":\"E11^Type 2 diabetes mellitus|E11.2^Type 2 diabetes mellitus with kidney complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E11.29\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Long term (current) use of insulin\",\"parent\":\"Z79^Long term (current) drug therapy\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"Z79.4\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Type 2 diabetes mellitus with diabetic dermatitis\",\"parent\":\"E11^Type 2 diabetes mellitus|E11.6^Type 2 diabetes mellitus with other specified complications|E11.62^Type 2 diabetes mellitus with skin complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E11.620\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Type 2 diabetes mellitus with diabetic autonomic (poly)neuropathy\",\"parent\":\"E11^Type 2 diabetes mellitus|E11.4^Type 2 diabetes mellitus with neurological complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E11.43\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Type 2 diabetes mellitus with diabetic peripheral angiopathy with gangrene\",\"parent\":\"E11^Type 2 diabetes mellitus|E11.5^Type 2 diabetes mellitus with circulatory complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E11.52\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Type 2 diabetes mellitus with diabetic neuropathic arthropathy\",\"parent\":\"E11^Type 2 diabetes mellitus|E11.6^Type 2 diabetes mellitus with other specified complications|E11.61^Type 2 diabetes mellitus with diabetic arthropathy\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E11.610\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Type 1 diabetes mellitus with other diabetic kidney complication\",\"parent\":\"E10^Type 1 diabetes mellitus|E10.2^Type 1 diabetes mellitus with kidney complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E10.29\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Type 1 diabetes mellitus with diabetic peripheral angiopathy with gangrene\",\"parent\":\"E10^Type 1 diabetes mellitus|E10.5^Type 1 diabetes mellitus with circulatory complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E10.52\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Type 1 diabetes mellitus with diabetic polyneuropathy\",\"parent\":\"E10^Type 1 diabetes mellitus|E10.4^Type 1 diabetes mellitus with neurological complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E10.42\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Type 1 diabetes mellitus with diabetic dermatitis\",\"parent\":\"E10^Type 1 diabetes mellitus|E10.6^Type 1 diabetes mellitus with other specified complications|E10.62^Type 1 diabetes mellitus with skin complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E10.620\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Other specified diabetes mellitus with other diabetic kidney complication\",\"parent\":\"E13^Other specified diabetes mellitus|E13.2^Other specified diabetes mellitus with kidney complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E13.29\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Other specified diabetes mellitus with diabetic polyneuropathy\",\"parent\":\"E13^Other specified diabetes mellitus|E13.4^Other specified diabetes mellitus with neurological complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E13.42\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Type 1 diabetes mellitus with diabetic autonomic (poly)neuropathy\",\"parent\":\"E10^Type 1 diabetes mellitus|E10.4^Type 1 diabetes mellitus with neurological complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E10.43\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Other specified diabetes mellitus with diabetic peripheral angiopathy with gangrene\",\"parent\":\"E13^Other specified diabetes mellitus|E13.5^Other specified diabetes mellitus with circulatory complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E13.52\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Other specified diabetes mellitus with diabetic dermatitis\",\"parent\":\"E13^Other specified diabetes mellitus|E13.6^Other specified diabetes mellitus with other specified complications|E13.62^Other specified diabetes mellitus with skin complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E13.620\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Other specified diabetes mellitus with diabetic autonomic (poly)neuropathy\",\"parent\":\"E13^Other specified diabetes mellitus|E13.4^Other specified diabetes mellitus with neurological complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E13.43\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Drug or chemical induced diabetes mellitus with other diabetic kidney complication\",\"parent\":\"E09^Drug or chemical induced diabetes mellitus|E09.2^Drug or chemical induced diabetes mellitus with kidney complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E09.29\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Drug or chemical induced diabetes mellitus with diabetic peripheral angiopathy with gangrene\",\"parent\":\"E09^Drug or chemical induced diabetes mellitus|E09.5^Drug or chemical induced diabetes mellitus with circulatory complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E09.52\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Drug or chemical induced diabetes mellitus with diabetic dermatitis\",\"parent\":\"E09^Drug or chemical induced diabetes mellitus|E09.6^Drug or chemical induced diabetes mellitus with other specified complications|E09.62^Drug or chemical induced diabetes mellitus with skin complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E09.620\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Diabetes mellitus due to underlying condition with other diabetic kidney complication\",\"parent\":\"E08^Diabetes mellitus due to underlying condition|E08.2^Diabetes mellitus due to underlying condition with kidney complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E08.29\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Type 2 diabetes mellitus with diabetic amyotrophy\",\"parent\":\"E11^Type 2 diabetes mellitus|E11.4^Type 2 diabetes mellitus with neurological complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E11.44\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Drug or chemical induced diabetes mellitus with neurological complications with diabetic polyneuropathy\",\"parent\":\"E09^Drug or chemical induced diabetes mellitus|E09.4^Drug or chemical induced diabetes mellitus with neurological complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E09.42\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Drug or chemical induced diabetes mellitus with neurological complications with diabetic autonomic (poly)neuropathy\",\"parent\":\"E09^Drug or chemical induced diabetes mellitus|E09.4^Drug or chemical induced diabetes mellitus with neurological complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E09.43\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Type 1 diabetes mellitus with diabetic neuropathic arthropathy\",\"parent\":\"E10^Type 1 diabetes mellitus|E10.6^Type 1 diabetes mellitus with other specified complications|E10.61^Type 1 diabetes mellitus with diabetic arthropathy\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E10.610\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Other specified diabetes mellitus with diabetic neuropathic arthropathy\",\"parent\":\"E13^Other specified diabetes mellitus|E13.6^Other specified diabetes mellitus with other specified complications|E13.61^Other specified diabetes mellitus with diabetic arthropathy\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E13.610\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Drug or chemical induced diabetes mellitus with diabetic neuropathic arthropathy\",\"parent\":\"E09^Drug or chemical induced diabetes mellitus|E09.6^Drug or chemical induced diabetes mellitus with other specified complications|E09.61^Drug or chemical induced diabetes mellitus with diabetic arthropathy\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E09.610\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Type 2 diabetes mellitus with mild nonproliferative diabetic retinopathy with macular edema\",\"parent\":\"E11^Type 2 diabetes mellitus|E11.3^Type 2 diabetes mellitus with ophthalmic complications|E11.32^Type 2 diabetes mellitus with mild nonproliferative diabetic retinopathy\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E11.321\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Diabetes mellitus due to underlying condition with diabetic peripheral angiopathy with gangrene\",\"parent\":\"E08^Diabetes mellitus due to underlying condition|E08.5^Diabetes mellitus due to underlying condition with circulatory complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E08.52\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Diabetes mellitus due to underlying condition with diabetic dermatitis\",\"parent\":\"E08^Diabetes mellitus due to underlying condition|E08.6^Diabetes mellitus due to underlying condition with other specified complications|E08.62^Diabetes mellitus due to underlying condition with skin complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E08.620\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Diabetes mellitus due to underlying condition with diabetic polyneuropathy\",\"parent\":\"E08^Diabetes mellitus due to underlying condition|E08.4^Diabetes mellitus due to underlying condition with neurological complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E08.42\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Diabetes mellitus due to underlying condition with diabetic autonomic (poly)neuropathy\",\"parent\":\"E08^Diabetes mellitus due to underlying condition|E08.4^Diabetes mellitus due to underlying condition with neurological complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E08.43\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Diabetes mellitus due to underlying condition with diabetic neuropathic arthropathy\",\"parent\":\"E08^Diabetes mellitus due to underlying condition|E08.6^Diabetes mellitus due to underlying condition with other specified complications|E08.61^Diabetes mellitus due to underlying condition with diabetic arthropathy\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E08.610\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Neonatal diabetes mellitus\",\"parent\":\"P70^Transitory disorders of carbohydrate metabolism specific to newborn\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"P70.2\",\"ageGroup\":\"0\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Type 2 diabetes mellitus with diabetic neuropathy, unspecified\",\"parent\":\"E11^Type 2 diabetes mellitus|E11.4^Type 2 diabetes mellitus with neurological complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E11.40\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Type 2 diabetes mellitus with diabetic mononeuropathy\",\"parent\":\"E11^Type 2 diabetes mellitus|E11.4^Type 2 diabetes mellitus with neurological complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E11.41\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Type 2 diabetes mellitus with diabetic cataract\",\"parent\":\"E11^Type 2 diabetes mellitus|E11.3^Type 2 diabetes mellitus with ophthalmic complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E11.36\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Type 2 diabetes mellitus with diabetic peripheral angiopathy without gangrene\",\"parent\":\"E11^Type 2 diabetes mellitus|E11.5^Type 2 diabetes mellitus with circulatory complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E11.51\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Type 1 diabetes mellitus with diabetic amyotrophy\",\"parent\":\"E10^Type 1 diabetes mellitus|E10.4^Type 1 diabetes mellitus with neurological complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E10.44\",\"ageGroup\":\"-1\"},{\"unacceptablePrinicpalCode\":\"false\",\"manifestationCode\":\"false\",\"description\":\"Other specified diabetes mellitus with diabetic amyotrophy\",\"parent\":\"E13^Other specified diabetes mellitus|E13.4^Other specified diabetes mellitus with neurological complications\",\"maternityCode\":\"false\",\"gender\":\"\",\"code\":\"E13.44\",\"ageGroup\":\"-1\"}]";
//	        while ((inputLine = in.readLine()) != null){
//	        System.out.println("ttt>>>"+inputLine);
	        	tt=new JSONArray(inputLine);
	        	
//	        }
//	        in.close();
			
//	        tesmethd(tt);
	        JSONArray ttt=	tesmethd(tt);
	        	System.out.println("finala out put MR Kishore>>>>"+ttt);
			out.print(ttt);
			out.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	int arraylength[][]=new int[1000][2];
//	List<Integer> ints = new ArrayList<Integer>();
	JSONArray overall=new JSONArray();
	JSONArray next=new JSONArray();
	JSONObject data=new JSONObject();
	String parent=null;
	JSONArray sorted=new JSONArray();
	Map<String,Object> newMap=  new HashMap<String,Object>();
	String array[]=null;
	public JSONArray tesmethd(JSONArray json) throws Exception
	{
		arraylength=new int[1000][2];
		overall=new JSONArray();
		next=new JSONArray();
		data=new JSONObject();
		sorted=new JSONArray();
		JSONArray harifinal=new JSONArray();
//		arraylength=new int[json.length()][];
		
//		for(int z=0;z<test.length;z++)
//		System.out.println(">>>"+test);
		
//		System.out.println("lll"+test1.length);
		/*for(int i=test1.length-1;i>=0;i--)
		System.out.println(">>>>1>>>"+test1[i]);*/
		
		for(int i=0;i<1000;i++)
		{
			arraylength[i][0]=-1;
			arraylength[i][1]=-1;
		}
		
		for(int j=0;j<json.length();j++)
		{
			String test=new JSONObject(json.get(j).toString()).get("parent").toString();
        	String test1[]=test.split("\\|");
        	arraylength[j][0]=test1.length;
        	arraylength[j][1]=j;
		}
		
		
		
		for (int j = 0; j<arraylength.length-1; j++) {
	        for (int k = j+1; k < arraylength.length; k++){
	            if (arraylength[j][0] < arraylength[k][0]) {
	                int dummy = arraylength[j][0];
	                int order=arraylength[j][1];
	                arraylength[j][0] = arraylength[k][0];
	                arraylength[j][1] = arraylength[k][1];
	                arraylength[k][0] = dummy; 
	                arraylength[k][1] = order; 
	            }
	        }
	    }
		
		array=new String[json.length()];
		for(int j=0,i=0;j<json.length();j++)
		{

			sorted.put(j, json.get(arraylength[j][1]));
			
		}
		
		
		
		
		

		
		/*for(int j=0;j<sorted.length();j++)
		{
			System.out.println("order>>>"+sorted.get(j));
		}*/
		
		/*for (int j = 0; j<json.length()-1; j++) {
	        for (int k = j+1; k < json.length(); k++){
	        	String test=new JSONObject(json.get(j).toString()).get("parent").toString();
	        	String test1[]=test.split("\\|");
	        	String testt=new JSONObject(json.get(k).toString()).get("parent").toString();
	        	String test12[]=testt.split("\\|");
	            if (test1.length < test12.length) {
	                JSONObject dummy = new JSONObject(json.get(j).toString());
	                json.put(j, json.get(k).toString());
	                json.put(j, dummy); 
	            }
	        }
	    }
		
		
		*/
		
		for(int j=0;j<sorted.length();j++)
		{
			String test=new JSONObject(sorted.get(j).toString()).get("parent").toString();
        	String test1[]=test.split("\\|");
//			System.out.println(">>>>"+test1.length+"<<<<value>>>>"+test);
        	int aa=0;
        	/*for(int i=0;i<complete0.size();i++)
        	if(complete0.get(i).get("parent").toString().equalsIgnoreCase(recursive(test1.length,j).get("parent").toString()))
        	{
        		aa=1;
        		System.out.println(">>>>>>>>>>>>>"+complete0.get(i).get("parent").toString()+"<<<<<<<???????>>>>>>>>"+recursive(test1.length,j).toString());
        		
        		complete0.add(j,havingrecursive(test1.length,j,complete0.get(i)));
        		System.out.println("<<<<<<<<<<<?>>>>>>>>>>>>>>"+complete0.get(j));
        	}
        	if(aa==0){*/
//        		System.out.println("first time here");
//        		newMap=  new HashMap<String,Object>();
//        	newMap.put("parent", recursive(test1.length,j).get("parent").toString());
//        	newMap.put("data", recursive(test1.length,j).toString());
//        	complete0.add(j,newMap);
//        	}
        	
        	overall.put(recursive(test1.length,j).toString());
        	
		}
		
		
		for(int j=0;j<overall.length();j++)
		{

			
			
			array[j]=new JSONObject(overall.get(j).toString()).get("parent").toString();
			if(new JSONObject(overall.get(j).toString()).get("parent").toString().trim().equalsIgnoreCase(""))
			{
			JSONObject emptyones=new JSONObject();
			emptyones.put("next", new JSONArray());
			emptyones.put("data", new JSONArray().put(new JSONObject(overall.get(j).toString())));
			emptyones.put("level",0 );
//			harifinal.put(emptyones);
			}
			
        	
		}
	String []removedu=removeDuplicates(array);
	for(int i=0;i<removedu.length;i++)
	{
		System.out.println(">>>>re>>>"+removedu[i]);
	}
		
	JSONObject all[]=new JSONObject[removedu.length];
	
	
	int z=0;
	for(int i=0;i<removedu.length;i++)
	{
		JSONArray list=new JSONArray();
		if(removedu[i].trim().equalsIgnoreCase("")){
			
			
		}else
		{
			all[z]=new JSONObject();
			all[z].put("parent",removedu[i]);
			
			for(int j=0;j<overall.length();j++)
			{
				if(all[z].get("parent").toString().trim().equalsIgnoreCase(new JSONObject(overall.get(j).toString()).get("parent").toString()))
				{
					list.put(new JSONObject(overall.get(j).toString()));
				}
				
			}
			all[z].put("list",list);
			z++;
		}
		
//		System.out.println(removedu[i]+">>>>"+all[i].get(0));
	}
		
		
		for(int i=0;i<z;i++)
		{
//			System.out.println(">>>>>all"+all[i].get("list")+">>>>"+all[i].get("parent"));
			
			JSONArray sp1=new JSONArray(all[i].get("list").toString());
			int sp1max=0;
			for(int spdd=0;spdd<sp1.length();spdd++)
			{
				JSONObject sp10=new JSONObject(sp1.get(spdd).toString());
				if(sp1max<Integer.parseInt(sp10.get("maxlevel").toString()))
				sp1max=Integer.parseInt(sp10.get("maxlevel").toString());
				
			}
			
			JSONObject hari= framejson(sp1max,sp1max);
			
			for(int spdd=0;spdd<sp1.length();spdd++)
			{
				JSONObject sp10=new JSONObject(sp1.get(spdd).toString());
				
//				System.out.println("into json /n/n"+Integer.parseInt(sp10.get("maxlevel").toString())+"\n\n\n\n");
				
				System.out.println("call from main"+Integer.parseInt(sp10.get("maxlevel").toString()));
				hari=insertjson(hari,Integer.parseInt(sp10.get("maxlevel").toString()),sp10,Integer.parseInt(sp10.get("maxlevel").toString()));
				
				System.out.println("total final hari>>"+hari);
			}
			
			harifinal.put(hari);
		}
		
		JSONArray kkkkkk=new JSONArray();
		
		/*for(int i=0;i<harifinal.length();i++)
		{
			System.out.println("harifinal>>>"+harifinal.get(i));
			kkkkkk.put(harifinal.get(index))
		}*/
		/*for(int i=0;i<complete0.size();i++)
		System.out.print(complete0.get(i)+",");*/
		
		return harifinal;
	}
	
	
	public JSONObject framejson(int level,int max) throws JSONException
	{
		JSONObject main=new JSONObject();
		
		main.put("data",new JSONArray());
		main.put("level",max-level);
		if(level==0){
			main.put("next",new JSONArray());
			return main;
		}
		
		return main.put("next",new JSONArray().put(framejson(level-1,max)));
		
	}
	
	
	public JSONObject insertjson(JSONObject hari,int level,JSONObject fromhari,int max) throws Exception
	{
		System.out.println("call in insert josn level from hari>>>"+Integer.parseInt(hari.get("level").toString()));
		
//		System.out.println("\n\n\n\nlevel"+hari.get("level").toString());
		if(Integer.parseInt(hari.get("level").toString())==level)
		{
			System.out.println("\n\n\n\nlevel"+level);
			hari.append("data",getdata(max,fromhari));
			System.out.println("total hari"+hari.toString());
			return hari;
		}
		else
		{
			hari.put("data", hari.get("data"));
//			System.out.println("in inside else block "+new JSONObject(new JSONArray(hari.get("next").toString()).get(0).toString()));
			
			hari.put("next", new JSONArray().put(insertjson(new JSONObject(new JSONArray(hari.get("next").toString()).get(0).toString()),level,fromhari,max)));
			return hari;
		}
		
	}
	
	public JSONObject getdata(int max,JSONObject fromhari) throws Exception
	{
		if(Integer.parseInt(fromhari.get("level").toString())==max)
		{
			
			return new JSONObject(fromhari.get("data").toString());
		
		}else
		{
			return getdata(max,new JSONObject(new JSONArray(fromhari.get("next").toString()).get(0).toString()));
		}
	}
	
	
	List<Map<String,Object>> complete0=new ArrayList<Map<String,Object>>();
	
	List<Object> complete1=new ArrayList<Object>();
	public JSONObject recursive(int json,int order) throws JSONException
	{
		/*String test=new JSONObject(json).get("parent").toString();
		String test1[]=test.split("\\|");*/
		
		JSONObject d123= new JSONObject();
		String test=new JSONObject(sorted.get(order).toString()).get("parent").toString();
    	String test1[]=test.split("\\|");
		d123.put("parent", test1[(test1.length-1)-(json-1)]);
		d123.put("level", (test1.length-1)-(json-1));
		d123.put("maxlevel", (test1.length-1));
		
		if(json==1)
		{
//			
			JSONObject test123=new JSONObject(sorted.get(order).toString());
//			d123.put("parent", value)
			d123.put("data", test123);
			d123.put("next", new JSONArray());
			return 	d123;
		}else
		{
			d123.put("next", new JSONArray().put(recursive(json-1,order)));
		}
		
//		JSO
			
		return d123;
	}
	
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	
	/*public static String[] removeDuplicates(String[] input){
        
        int j = 0;
        int i = 1;
        //return if the array length is less than 2
        if(input.length < 2){
            return input;
        }
        while(i < input.length){
            if(input[i].trim().equalsIgnoreCase(input[j].trim())){
                i++;
            }else{
                input[++j] = input[i++];
            }   
        }
        String[] output = new String[j+1];
        for(int k=0; k<output.length; k++){
            output[k] = input[k];
        }
         
        return output;
    }*/
	
	
	public static String[] removeDuplicates(String[] arr) { 
        int end = arr.length;

        for (int i = 0; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if (arr[i].trim().equalsIgnoreCase(arr[j].trim())) {                  
                    int shiftLeft = j;

                    for(int k = j + 1; k < end; k++, shiftLeft++) {
                        arr[shiftLeft] = arr[k];
                    }

                    end--;
                    j--;
                }
            }
        }

        String[] whitelist = new String[end];

        for (int i = 0; i < end; i++) {
//        	if(!arr[i].trim().equalsIgnoreCase(""))
            whitelist[i] = arr[i];
        }

        return whitelist;
    }


}

package fr.eservice.rallyman.model.helper;

import java.util.HashMap;
import java.util.Map;

import fr.eservice.rallyman.model.Constantes;

/**
 *  
 * @author rally-devteam
 */
public class NatureHelper {

	protected static Map<String, Integer> mapNatureDegat;
	
	static {
		mapNatureDegat = new HashMap<String, Integer>();
		
		mapNatureDegat.put(Constantes.TYPE_FORET, 0);
		mapNatureDegat.put(Constantes.TYPE_HERBE, 0);
		mapNatureDegat.put(Constantes.TYPE_NEIGE, 0);
		mapNatureDegat.put(Constantes.TYPE_PLAN_EAU, 0);
		mapNatureDegat.put(Constantes.TYPE_ROCHERS, 0);
		mapNatureDegat.put(Constantes.TYPE_TERRE, 0);
		mapNatureDegat.put(Constantes.TYPE_VILLAGE, 0);
		
	}
	
	
	public static Integer recupererDegats(String nature) {
		if (mapNatureDegat.containsKey(nature)) {
			return mapNatureDegat.get(nature);			
		}
		return null;
	}
	
}

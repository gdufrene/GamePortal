<%@page import="manhattan.*"%>
<!DOCTYPE html>
<html lang="fr-FR">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Manhattan</title>
</head>
<body>
Manhattan - Joueur 1 
<% 
	String name = request.getParameter("name");
	out.print("("+name+")"); 
%>
<table width="700" height="450">
  <tr>
    <td width="33%"><table id="scores" width="100%" border="1">
	  <tr>
        <td id="score_16">16</td>
        <td id="score_32">32</td>
        <td id="score_48">48</td>
        <td id="score_64">64</td>
        <td id="score_80">80</td>
      </tr>
      <tr>
        <td id="score_15">15</td>
        <td id="score_31">31</td>
        <td id="score_47">47</td>
        <td id="score_63">63</td>
        <td id="score_79">79</td>
      </tr>
      <tr>
        <td id="score_14">14</td>
        <td id="score_30">30</td>
        <td id="score_46">46</td>
        <td id="score_62">62</td>
        <td id="score_78">78</td>
      </tr>
      <tr>
        <td id="score_13">13</td>
        <td id="score_29">29</td>
        <td id="score_45">45</td>
        <td id="score_61">61</td>
        <td id="score_77">77</td>
      </tr>
      <tr>
        <td id="score_12">12</td>
        <td id="score_28">28</td>
        <td id="score_44">44</td>
        <td id="score_60">60</td>
        <td id="score_76">76</td>
      </tr>
      <tr>
        <td id="score_10">11</td>
        <td id="score_27">27</td>
        <td id="score_43">43</td>
        <td id="score_59">59</td>
        <td id="score_75">75</td>
      </tr>
      <tr>
        <td id="score_11">10</td>
        <td id="score_26">26</td>
        <td id="score_42">42</td>
        <td id="score_58">58</td>
        <td id="score_74">74</td>
      </tr>
      <tr>
        <td id="score_10">9</td>
        <td id="score_25">25</td>
        <td id="score_41">41</td>
        <td id="score_57">57</td>
        <td id="score_73">73</td>
      </tr>
      <tr>
        <td id="score_09">8</td>
        <td id="score_24">24</td>
        <td id="score_40">40</td>
        <td id="score_56">56</td>
        <td id="score_72">72</td>
      </tr>
      <tr>
        <td id="score_08">7</td>
        <td id="score_23">23</td>
        <td id="score_39">39</td>
        <td id="score_55">55</td>
        <td id="score_71">71</td>
      </tr>
      <tr>
        <td id="score_07">6</td>
        <td id="score_22">22</td>
        <td id="score_38">38</td>
        <td id="score_54">54</td>
        <td id="score_70">70</td>
      </tr>
      <tr>
        <td id="score_05">5</td>
        <td id="score_21">21</td>
        <td id="score_37">37</td>
        <td id="score_53">53</td>
        <td id="score_69">69</td>
      </tr>
      <tr>
        <td id="score_04">4</td>
        <td id="score_20">20</td>
        <td id="score_36">36</td>
        <td id="score_52">52</td>
        <td id="score_68">68</td>
      </tr>
      <tr>
        <td id="score_03">3</td>
        <td id="score_19">19</td>
        <td id="score_35">35</td>
        <td id="score_51">51</td>
        <td id="score_67">67</td>
      </tr>
      <tr>
        <td id="score_02">2</td>
        <td id="score_18">18</td>
        <td id="score_34">34</td>
        <td id="score_50">50</td>
        <td id="score_66">66</td>
      </tr>
      <tr>
        <td id="score_01">1</td>
        <td id="score_17">17</td>
        <td id="score_33">33</td>
        <td id="score_49">49</td>
        <td id="score_65">65</td>
      </tr>
    </table></td>
    <td width="67%"><table width="100%" height="50%">
      <tr>
        <td><table id="quartierA" width="100%" height="100%" border="1">
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
        <td><table id="quartierB" width="100%" height="100%" border="1">
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
        <td><table id="quartierC" width="100%" height="100%" border="1">
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td><table id="quartierD" width="100%" height="100%" border="1">
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
        <td><table id="quartierE" width="100%" height="100%" border="1">
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
        <td><table id="quartierF" width="100%" height="100%" border="1">
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="200">
  <tr>
    <td id="carte1"></td>
    <td id="carte2"></td>
    <td id="carte3"></td>
    <td id="carte4"></td>
  </tr>
</table>
<table border="1">
  <tr>
    <td>&nbsp;</td>
    <td id="pion1"></td>
    <td id="pion2"></td>
    <td id="pion3"></td>
    <td id="pion4"></td>
  </tr>
  <tr>
    <td>Batiments choisis (reste 6)</td>
    <td>0</td>
    <td>0</td>
    <td>0</td>
    <td>0</td>
  </tr>
  <tr>
    <td>Batiments restants</td>
    <td>12</td>
    <td>6</td>
    <td>4</td>
    <td>3</td>
  </tr>
</table>

<script type="text/javascript" />
	
	var JOUEUR = 1; // Recuperer la valeur 
	var score = 0;
	
	function generate_carte(value) {
		var carte = document.createElement('img');
		carte.src = asset('cartes/CARTE'+ value + '.png');
		return carte;
	}
	
	function generate_pion(nom) {
		var pion = document.createElement('img');
		pion.src =  asset('pions/'+ nom + '.png');
		return pion;
	}
	
	function init_pions() {			
		var pion1 = document.getElementById("pion1");
		var pion2 = document.getElementById("pion2");
		var pion3 = document.getElementById("pion3");
		var pion4 = document.getElementById("pion4");

		if (JOUEUR === 1) {
			pion1.appendChild(generate_pion("pionts_blue_1_small"));
			pion2.appendChild(generate_pion("pionts_blue_2_small"));
			pion3.appendChild(generate_pion("pionts_blue_3_small"));
			pion4.appendChild(generate_pion("pionts_blue_4_small"));
		}
		else if (JOUEUR === 2) {
			pion1.appendChild(generate_pion("pionts_grey_1_small"));
			pion2.appendChild(generate_pion("pionts_grey_2_small"));
			pion3.appendChild(generate_pion("pionts_grey_3_small"));
			pion4.appendChild(generate_pion("pionts_grey_4_small"));			
		}
		else if (JOUEUR === 3) {
			pion1.appendChild(generate_pion("pionts_orange_1_small"));
			pion2.appendChild(generate_pion("pionts_orange_2_small"));
			pion3.appendChild(generate_pion("pionts_orange_3_small"));
			pion4.appendChild(generate_pion("pionts_orange_4_small"));			
		}
		else if (JOUEUR === 4) {
			pion1.appendChild(generate_pion("pionts_purple_1_small"));
			pion2.appendChild(generate_pion("pionts_purple_2_small"));
			pion3.appendChild(generate_pion("pionts_purple_3_small"));
			pion4.appendChild(generate_pion("pionts_purple_4_small"));			
		}
	}
	
	function init_cartes() { // r�cup�rer les valeurs 
		var carte1 = document.getElementById("carte1");
		var carte2 = document.getElementById("carte2");
		var carte3 = document.getElementById("carte3");
		var carte4 = document.getElementById("carte4");
		
		carte1.appendChild(generate_carte(1));
		carte2.appendChild(generate_carte(2));
		carte3.appendChild(generate_carte(3));
		carte4.appendChild(generate_carte(4));
	}
	
	function asset(src) {
		return '/assets/manhattan/img/' + src;
	}
	
	init_pions();
	init_cartes();
	
</script>

</body>
</html>
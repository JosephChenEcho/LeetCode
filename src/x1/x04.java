/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x1;

import java.util.*;
//import java.math.*;

/**Unsolved Hard:
 * 41, 42, 44, 45, 52(Can improve), 56, 67 
 * Solved 51
 * @author Joseph
 */
public class x04 {
    public static void main(String[] args){
        String[] input = {"compilations","bewailed","horology","lactated","blindsided","swoop","foretasted","ware","abuts","stepchild","arriving","magnet","vacating","relegates","scale","melodically","proprietresses","parties","ambiguities","bootblacks","shipbuilders","umping","belittling","lefty","foremost","bifocals","moorish","temblors","edited","hint","serenest","rendezvousing","schoolmate","fertilizers","daiquiri","starr","federate","rectal","case","kielbasas","monogamous","inflectional","zapata","permitted","concessions","easters","communique","angelica","shepherdess","jaundiced","breaks","raspy","harpooned","innocence","craters","cajun","pueblos","housetop","traits","bluejacket","pete","snots","wagging","tangling","cheesecakes","constructing","balanchine","paralyzed","aftereffects","dotingly","definitions","renovations","surfboards","lifework","knacking","apprises","minimalism","skyrocketed","artworks","instrumentals","eardrums","hunching","codification","vainglory","clarendon","peters","weeknight","statistics","ay","aureomycin","lorrie","compassed","speccing","galen","concerto","rocky","derision","exonerate","sultrier","mastoids","repackage","cyclical","gowns","regionalism","supplementary","bierce","darby","memorize","songster","biplane","calibrates","decriminalizes","shack","idleness","confessions","snippy","barometer","earthing","sequence","hastiness","emitted","superintends","stockades","busywork","dvina","aggravated","furbelow","hashish","overextended","foreordain","lie","insurance","recollected","interpreted","congregate","ranks","juts","dampen","gaits","eroticism","neighborhoods","perihelion","simulations","fumigating","balkiest","semite","epicure","heavier","masterpiece","bettering","lizzie","wail","batsmen","unbolt","cudgeling","bungalow","behalves","refurnishes","pram","spoonerisms","cornered","rises","encroachments","gabon","cultivation","parsed","takeovers","stampeded","persia","devotional","doorbells","psalms","cains","copulated","archetypal","cursores","inbred","paradigmatic","thesauri","rose","stopcocks","weakness","ballsier","jagiellon","torches","hover","conservationists","brightening","dotted","rodgers","mandalay","overjoying","supervision","gonads","portage","crap","capers","posy","collateral","funny","garvey","ravenously","arias","kirghiz","elton","gambolled","highboy","kneecaps","southey","etymology","overeager","numbers","ebullience","unseemly","airbrushes","excruciating","gemstones","juiciest","muftis","shadowing","organically","plume","guppy","obscurely","clinker","confederacies","unhurried","monastic","witty","breastbones","ijsselmeer","dublin","linnaeus","dervish","bluefish","selectric","syllable","pogroms","pacesetters","anastasia","pandora","foci","bipartisan","loomed","emits","gracious","warfare","uncouples","augusts","portray","refinery","resonances","expediters","deputations","indubitably","richly","motivational","gringo","hubris","mislay","scad","lambastes","reemerged","wart","zirconium","linus","moussorgsky","swopped","sufferer","sputtered","tamed","merrimack","conglomerate","blaspheme","overcompensate","rheas","pares","ranted","prisoning","rumor","gabbles","lummox","lactated","unzipping","tirelessly","backdate","puzzling","interject","rejections","bust","centered","oxymoron","tangibles","sejong","not","tameness","consumings","prostrated","rowdyism","ardent","macabre","rustics","dodoes","warheads","wraths","bournemouth","staffers","retold","stiflings","petrifaction","larkspurs","crunching","clanks","briefest","clinches","attaching","extinguished","ryder","shiny","antiqued","gags","assessments","simulated","dialed","confesses","livelongs","dimensions","lodgings","cormorants","canaries","spineless","widening","chappaquiddick","blurry","lassa","vilyui","desertions","trinket","teamed","bidets","mods","lessors","impressiveness","subjugated","rumpuses","swamies","annotations","batiks","ratliff","waxwork","grander","junta","chutney","exalted","yawl","joke","vocational","diabetic","bullying","edit","losing","banns","doleful","precision","excreting","foals","smarten","soliciting","disturbance","soggily","gabrielle","margret","faded","pane","jerusalem","bedpan","overtaxed","brigs","honors","repackage","croissants","kirov","crummier","limeades","grandson","criers","bring","jaundicing","omnibusses","gawking","tonsillectomies","deodorizer","nosedove","commence","faulkner","adultery","shakedown","wigwag","wiper","compatible","ultra","adamant","distillation","gestates","semi","inmate","onlookers","grudgingly","recipe","chaise","dialectal","aphids","flimsier","orgasm","sobs","swellheaded","utilize","karenina","irreparably","preteen","mumble","gingersnaps","alumnus","chummiest","snobbish","crawlspaces","inappropriate","ought","continence","hydrogenate","eskimo","desolated","oceanic","evasive","sake","laziest","tramps","joyridden","acclimatized","riffraff","thanklessly","harmonizing","guinevere","demanded","capabler","syphilitics","brainteaser","creamers","upholds","stiflings","walt","luau","deafen","concretely","unhand","animations","map","limbos","tranquil","windbreakers","limoges","varying","declensions","signs","green","snowbelt","homosexual","hopping","residue","ransacked","emeritus","pathologist","brazenly","forbiddingly","alfredo","glummest","deciphered","delusive","repentant","complainants","beets","syntactics","vicissitude","incompetents","concur","canaan","rowdies","streamer","martinets","shapeliness","videodiscs","restfulness","rhea","consumed","pooching","disenfranchisement","impoverishes","behalf","unsuccessfully","complicity","ulcerating","derisive","jephthah","clearing","reputation","kansan","sledgehammer","benchmarks","escutcheon","portfolios","mandolins","marketable","megalomaniacs","kinking","bombarding","wimple","perishes","rukeyser","squatter","coddle","traditionalists","sifts","agglomerations","seasonings","brightness","spices","claimant","sofas","ambulatories","bothered","businessmen","orly","kinetic","contracted","grenadiers","flooding","dissolved","corroboration","mussed","squareness","alabamans","dandelions","labyrinthine","pot","waxwing","residential","pizza","overjoying","whelps","overlaying","elanor","tented","masterminded","balsamed","powerhouses","tramps","eisenstein","voile","repellents","beaus","coordinated","wreckers","eternities","untwists","estrangements","vitreous","embodied"};
        List<List<String>> output = groupAnagrams(input);
        for(List<String> al : output){
            System.out.print("Set : ");
            for(String str : al){
                System.out.print(str + ",");
            }
            System.out.println();
        }
    }
    
    //43. Multiply Strings
    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }  

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
    
    //46. Permutations
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> retlist = new ArrayList<>();
        List<Integer> numlist = new ArrayList();
        for(int i : nums){
            numlist.add(i);
        }                     
        return permuteSet(retlist, numlist);
    }
    
    public static List<List<Integer>> permuteSet(List<List<Integer>> inlist, List<Integer> innums){
        List<List<Integer>> outlist = new ArrayList();
        if (innums.size() == 0) return inlist;
        if (inlist.size() == 0){
            for(int i = 0; i < innums.size(); i++){
                List<Integer> outnums = new ArrayList(innums);
                List<Integer> tmplist = new ArrayList();
                tmplist.add(innums.get(i));
                outnums.remove(i);
                List<List<Integer>> tlist = new ArrayList();
                tlist.add(tmplist);
                //outlist.addAll(permuteSet( tlist,outnums));
                for(List<Integer> als : permuteSet(tlist ,outnums)){
                    if(!outlist.contains(als)) outlist.add(als);
                }
            }     
            return outlist;
        }
        for(List<Integer> al : inlist){
            for(int i = 0; i < innums.size(); i++){
                List<Integer> outnums = new ArrayList(innums);
                List<Integer> tmplist = new ArrayList(al);
                tmplist.add(innums.get(i));
                outnums.remove(i);
                List<List<Integer>> tlist = new ArrayList();
                tlist.add(tmplist);
                //outlist.addAll(permuteSet(tlist ,outnums));
                for(List<Integer> als : permuteSet(tlist ,outnums)){
                    if(!outlist.contains(als)) outlist.add(als);
                }
            }
        }
        return outlist;
    }
    
    //47. Permutations II Need more understanding on it
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) return ret;        
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];        
        permuteHelper(nums, 0, ret, used, new ArrayList<Integer>());        
        return ret;
    }
    
    private static void permuteHelper(int[] nums, int len, List<List<Integer>> ret, boolean[] used, List<Integer> curr) {
        System.out.print("Set :");
        for(int i : curr){
            System.out.print(i + ",");
        }
        System.out.print("len = "+len);
        for(boolean i : used){
            System.out.print(i + ",");
        }
        System.out.println();
        
        if (len == nums.length) {
            ret.add(new ArrayList<Integer>(curr));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
                    continue;
                }
                used[i] = true;
                curr.add(nums[i]);
                permuteHelper(nums, len + 1, ret, used, curr);
                curr.remove(curr.size() - 1);
                used[i] = false;
            }
        }
    }
    
    //48. Rotate Image
    public static void rotate(int[][] matrix) {
        //if len =6 mid: 3/3
        //if len = 7 mid 4/3
        int limitx = (matrix.length + 1)/2;
        int limity = matrix.length - limitx;
        int lefttopx = 0;
        int lefttopy = 0;
        int righttopx = matrix.length - 1;
        int righttopy = 0;
        int leftbottomx = 0;
        int leftbottomy = matrix.length - 1;
        int rightbottomx = matrix.length - 1;
        int rightbottomy = matrix.length - 1;
        
        for(int i = 0; i < limitx; i++){
            for(int j = 0; j < limity; j++){
                int tmp = matrix[lefttopx + i][lefttopy + j];
                matrix[lefttopx + i][lefttopy + j] = matrix[righttopx - j][righttopy + i];
                matrix[righttopx - j][righttopy + i] = matrix[rightbottomx - i][rightbottomy - j];
                matrix[rightbottomx - i][rightbottomy - j] = matrix[leftbottomx + j][leftbottomy - i];
                matrix[leftbottomx + j][leftbottomy - i] = tmp;
            }
        }
    }   

    //49. Group Anagrams    
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }

        Set<String> group = new HashSet<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String origin = new String(chars);
            if (group.add(origin)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(origin, list);
            } else {
                map.get(origin).add(str);
            }
        }
        for (String g : group) {
            result.add(map.get(g));
        }
        return result;
    }
    
    public static boolean isAnagrams(String a, String b){
        HashMap<Character,Integer> hmapa = new HashMap();
        HashMap<Character,Integer> hmapb = new HashMap();
        
        for(char c : a.toCharArray()){
            if(!hmapa.containsKey(c)){
                hmapa.put(c, 1);
            }else{
                int cnt = hmapa.get(c);
                hmapa.put(c, cnt + 1);
            }
        }        
        for(char c : b.toCharArray()){
            if(!hmapb.containsKey(c)){
                hmapb.put(c, 1);
            }else{
                int cnt = hmapb.get(c);
                hmapb.put(c, cnt + 1);
            }
        }        
        List<Character> uniqueChar = new ArrayList();
        for(char c : a.toCharArray()){
            if(!uniqueChar.contains(c)) uniqueChar.add(c);
        }
        for(char c : b.toCharArray()){
            if(!uniqueChar.contains(c)) uniqueChar.add(c);
        }        
        for(char c : uniqueChar){
            if(!hmapa.containsKey(c))
                return false;
            if(!hmapb.containsKey(c))
                return false;
            int cnta = hmapa.get(c);
            int cntb = hmapb.get(c);
            if(cnta != cntb){                
                return false;
            }
        }           
        return true;
    }
    
    //51. N-Queens
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> retlist = new ArrayList();        
        int[] board = new int[n];
        nQueenHelper(retlist, board, 0);        
        return retlist;
    }
    
    public static Boolean nQueenHelper(List<List<String>> retlist, int[] inboard,int idx){
        if(idx >= inboard.length){
            /*System.out.print("Solution : ");
            for(int i : inboard){
                System.out.print(i + ",");
            }
            System.out.println();*/
            List<String> solutionlist = new ArrayList();
            for(int iq : inboard){
                char[] cstr = new char[inboard.length];
                for(int i = 0; i < cstr.length; i++){
                    cstr[i] = '.';                    
                }
                cstr[iq] = 'Q';
                solutionlist.add(String.valueOf(cstr));
            }
            retlist.add(solutionlist);
            return true;
        }
        
        for(int i = 0; i < inboard.length; i++){
            int[] outboard = inboard.clone();
            outboard[idx] = i;
            if(validBoard(outboard,idx)){
                nQueenHelper(retlist,outboard,idx + 1);
            }
        }
        
        return false;
    }
    
    public static Boolean validBoard(int[] board, int idx){
        for(int i = 0; i < idx; i++){
            if(board[i] == board[idx]) return false;
            if(Math.abs(board[i] - board[idx]) == (idx - i) ) return false;
        }        
        return true;
    }
    
    //52. N-Queens II
    public static int totalNQueens(int n) {        
        List<List<String>> retlist = new ArrayList();        
        int[] board = new int[n];
        nQueenHelper(retlist, board, 0);        
        return retlist.size();
    }
    
    

}

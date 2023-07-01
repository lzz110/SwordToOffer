package MatchClass;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author lzz
 * @version 1.0
 * @description: TODO
 * @date 2020/9/18 9:53
 */
public class regex {

    public static void main(String[] args) {
//        String str="And millionaires will hold 46% of total wealth by 2019, the report says. This ratio is likely to increase in 2020.";
//        String str="And 4008millionaires 5895will hold 46% of total wealth by 2019, the report says. This ratio is likely to increase in 2020.";
//        String str="201003abc2020";
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str= sc.nextLine();
            ArrayList<String> res=new ArrayList<>();
//            ArrayList<String> test=findYear("\\d{2000}",str);
            ArrayList<String> test=findYear("[0-9]*",str);
            for(String s:test){
                if(s.length()==4){
                    res.add(s);
                }
//                System.out.println(s);
            }
//            for(String s:test){
//                if(Integer.parseInt(s)>=1000&&Integer.parseInt(s)<3999){
//                    res.add(s);
//                }
//            }
            for(int i=0;i<res.size();i++){
                if(i!=res.size()-1){
                    System.out.print(res.get(i)+" ");
                }else{
                    System.out.print(res.get(i));
                }
            }
        }
    }


    public static ArrayList<String> findYear(String regex,String context){
        ArrayList<String> res=new ArrayList<>();
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher m = pattern.matcher(context);
        while(m.find()){
            res.add(m.group());
        }
        return res;
    }

}


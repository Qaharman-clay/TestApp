package com.example.testapp.controller;

import com.example.testapp.data.TestData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Controller {
    private List<TestData> list;
    private int position=0;


    private int correctAnswer;
    private int wrongAnswer;
    private int skipAnswer;

    private  final  int MAX_COUNT=30;

    {
        loadData();
    }

    private void loadData() {
        list=new ArrayList<>();
        list.add(new TestData("2021-jili quwnaqlar ham ziyrekler korik tanlawinda qaysi komanda chempion boldi? ","Turan","Agrolife","Almaz","Yangi yulduzlar","Almaz"));
        list.add(new TestData("2015-jili quwnaqlar ham ziyrekler korik tanlawinda qaysi komanda chempion boldi? ","Turan","Agrolife","Almaz","Yangi yulduzlar","Turan"));
        list.add(new TestData("2020-jili quwnaqlar ham ziyrekler korik tanlawinda qaysi komanda chempion boldi? ","Turan","Agrolife","Almaz","Yangi yulduzlar","Turan"));
        list.add(new TestData("6*5","15","30","45","60","30"));
        list.add(new TestData("3^6","81","125","729","1331","729"));
        list.add(new TestData("10 sanin rim cifrinda jazip berin'","M","L","X","XX","X"));
        list.add(new TestData("3 kunde neshe saat bar?","48","46","72","81","72"));
        list.add(new TestData("Tariyxtin' atasi kim?","Eratosfen","Geradod","Beruniy","Al-Xorezmiy","Geradod"));
        list.add(new TestData("Matematika panine ulken ulew qosqan alim","Eratosfen","Geradod","Beruniy","Al-Xorezmiy","Al-Xorezmiy"));
        list.add(new TestData("Jerdn' birinshi bolip kartasin islegen alim","Eratosfen","Geradod","Beruniy","Al-Xorezmiy","Beruniy"));
        list.add(new TestData("Aleksandr Makedonskiydin ustazi kim bolg'an","Arximed","Aristotel","Nyuton","Kopernik","Aristotel"));
        list.add(new TestData("Erkin tusiw tezleniwi neshege ten'","9.81","8.31","6.02","4.23","9.81"));
        list.add(new TestData("Birinshi kino neshinshi jil islep shigarilgan","1906","1823","1895","1900","1895"));
        list.add(new TestData("Universal gaz turaqlisi neshege ten'","9.81","8.31","6.02","4.23","8.31"));
        list.add(new TestData("Qaysi haywan sut emiziwshiler qatarina kiredi","akula","exidna","lantcetnik","kesirtke","exidna"));
        list.add(new TestData("Dunyadag'i en' ulken okean","arqa muz","hind","tinish","atlantika","tinish"));
        list.add(new TestData("Hazirge deyin saqlanip qalgan dunyadagi 7 karamattin biri","Zevs haykeli","Gelios haykeli","piramidalar","artemida ibadatxanasi","piramidalar"));
        list.add(new TestData("Maglumattin en kishi olshem birligi","MB","kB","GB","bit","bit"));
        list.add(new TestData("Adam organizmindegi en ulken bez","Bawir","Talaq","Asqazan asti bezi","Qalqan tarizli bez","Bawir"));
        list.add(new TestData("En biyik taw","gimalay","ant","qarataw","alp","gimalay"));
        list.add(new TestData("Kush neshege bolinedi","2","3","4","5","5"));
        list.add(new TestData("Eyfel minarasinin saqlanip qaliwina ne sebep bolgan","internet oylap tabiliwi","radio oylap tabiliwi","televizor","telefon","radio oylap tabiliwi"));
        list.add(new TestData("Counter Strike oyini qashan payda bolgan","2001","1999","2000","2003","1999"));
        list.add(new TestData("Dunyadagi en shuqur kol","Baykal","Kaspiy","Ashshi kol","Qamis ariq","Baykal"));
        list.add(new TestData("En mayda qan tamir","Vena","Arteriya","Aorta","Kapeliyar","Kapeliyar"));
        list.add(new TestData("Marvel studios tarepinen x-men kinosi neshinshi jili shigarilgan","2003","2002","2001","2000","2000"));
        list.add(new TestData("Amir Temur qashan tuwilgan","1405","1346","1336","1365","1336"));
        list.add(new TestData("Jumong serialinda Jumongtin akesinin' ati","Geumva","Euri","Xayomosu","Yontabal","Xayomosu"));
        list.add(new TestData("Microsoft tarepinen islep shigarilgan oyin","Dota","Counter Strike","Minecraft","Need for speed","Minecraft"));
        list.add(new TestData("AQSHtin birinshi prezidenti","Djorj Vashington","Donald Tramp","Barak Obama","Benjamin Franklin","Djorj Vashington"));


        Collections.shuffle(list);
    }

    public  TestData getDataByPosition()
    {
        return list.get(position++);
    }

    public boolean isLastQuestion()
    {

     return position<MAX_COUNT;
    }
    public int getPosition() {
        return position;
    }

    public int getMAX_COUNT() {
        return MAX_COUNT;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public int getWrongAnswer() {
        return wrongAnswer;
    }

    public int getSkipAnswer() {
        return skipAnswer;
    }

    public void checkUserAnswer(String userAnswer)
    {
        if(list.get(position-1).getAnswer().equals(userAnswer)){
            correctAnswer++;
        }
        else wrongAnswer++;

    }

    public void setSkipAnswer()
    {
        skipAnswer++;
    }
}

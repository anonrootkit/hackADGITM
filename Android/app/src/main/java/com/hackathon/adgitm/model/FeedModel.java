package com.hackathon.adgitm.model;

import java.util.ArrayList;

public class FeedModel {
    private String heading;
    private String answer;

    public FeedModel(){}
    public FeedModel(String heading, String answer) {
        this.heading = heading;
        this.answer = answer;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public ArrayList<FeedModel> getFeed(){
        ArrayList<FeedModel> list = new ArrayList<>();
        list.add(new FeedModel("Yoga se hoga!", "Yoga's incorporation of meditation and breathing can help improve a person's mental well-being. “Regular yoga practice creates mental clarity and calmness; increases body awareness; relieves chronic stress patterns; relaxes the mind; centers attention; and sharpens concentration."));
        list.add(new FeedModel("Why healthy diet ?","A healthy diet can protect the human body against certain types of diseases, in particular noncommunicable diseases such as obesity, diabetes, cardiovascular diseases, some types of cancer and skeletal conditions. Healthy diets can also contribute to an adequate body weight."));
        list.add(new FeedModel("Weight training good or bad?!","Weight training does so much more for your body to keep you healthy and prevent injuries and bone loss. Weight training is a great way to burn calories, gain muscle mass, increase flexibility, decrease body fat, increase bone density and even enhance cardiovascular fitness."));
        list.add(new FeedModel("Fruit myth vs reality?","While excessive sugar intake can be harmful, this doesn't apply to whole fruits. ... If you can tolerate fruit and you're not on a low-carb or ketogenic diet, by all means, eat fruit. Try eating more whole fruits as part of a healthy, real-foods-based diet to enjoy their health benefits."));
        list.add(new FeedModel("Cholesterol?","Cholesterol is a waxy substance found in your blood. Your body needs cholesterol to build healthy cells, but high levels of cholesterol can increase your risk of heart disease. With high cholesterol, you can develop fatty deposits in your blood vessels."));
        list.add(new FeedModel("I'll strart from tommorow!!","Exercise strengthens your heart and improves your circulation. The increased blood flow raises the oxygen levels in your body. This helps lower your risk of heart diseases such as high cholesterol, coronary artery disease, and heart attack. Regular exercise can also lower your blood pressure and triglyceride levels."));
        list.add(new FeedModel("Benifit of stretching ","Stretching is a popular exercise regimen that may have many benefits. Your physical therapist can show you the best ways to stretch to help keep you moving with a full range of motion. Stretching is the deliberate lengthening of muscles in order to increase muscle flexibility and joint range of motion."));
        list.add(new FeedModel("FAT myths ?!","MYTH? If the label says \"no-fat\" or \"low-fat,\" you can eat all you want and not gain weight. \nFACT: Many low-fat or no-fat foods have added sugar, starch, or salt to make up for the reduction in fat. These \"wonder\" foods often have just as many calories, or more, than the regular version."));
        list.add(new FeedModel("Effect of social life on heath!", "Social relationships—both quantity and quality—affect mental health, health behavior, physical health, and mortality risk. Sociologists have played a central role in establishing the link between social relationships and health outcomes."));
        return list;
    }
}

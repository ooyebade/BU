# -*- coding: utf-8 -*-
"""
Elizabeth Oyebade
Class: CS 521 - Spring 2
Date: 4/25/2021
Homework Problem #6.12.2
Write a program for the human body organs with properties in common and others
that are specialized using classes. 
"""

# defining the organ class
class Organ:
    # constructor
    # representing the 'Organ' base class
    def __init__(self, organ_name, organ_weight_grams, is_vital_organ, 
                 organ_system, is_transplantable, organ_gender):
        self.organ_name = organ_name
        self.organ_weight_grams = organ_weight_grams
        self.is_vital_organ = is_vital_organ
        self.organ_system = organ_system
        self.is_transplantable = is_transplantable
        self.organ_gender = organ_gender
    # repr method that returns the attributes of organ instance
    def __repr__(self):
        return f"Organ name: {self.organ_name},\
        Organ weight: {self.organ_weight_grams},\
        Organ is_vital: {self.is_vital_organ},\
            Organ system: {self.organ_system},\
            Organ is_transplantable: {self.is_transplantable}, \
                Organ gender: {self.organ_gender}"
# defining the heart class
class Heart(Organ):
    # constructor
    # representing the 'Heart' class
    def __init__(self, heart_length_cm, heart_weight_grams, 
                 heart_thickness_cm, heart_breadth_cm):
        # parent class method
        Organ.__init__(self, "Heart", heart_weight_grams, True, 
                       "Musclar system", True, "Female")
        self.heart_length_cm = heart_length_cm
        self.heart_weight_grams = heart_weight_grams
        self.heart_thickness_cm = heart_thickness_cm
        self.heart_breadth_cm = heart_breadth_cm
    # repr method that returns the attributes of heart instance
    def __repr__(self):
        return Organ.__repr__(self)+ f"\nHeart length:{self.heart_length_cm},\
            Heart weight: {self.heart_weight_grams},\
            Heart thickness: {self.heart_thickness_cm},\
                        Heart breadth: {self.heart_breadth_cm}"
    # general method for heart class
    # return 'pumping blood'
    def heart_status(self):
        return "Pumping blood"
    # return heart weight in ounces
    def heart_weight_oz(self):
        return 0.035 * self.heart_weight_grams
# defining the brain class
class Brain(Organ):
    # constructor
    # representing the brain class
    def __init__(self, brain_volume, brain_weight_gram):
        # parent class method
        Organ.__init__(self, "Brain", brain_weight_gram, True, 
                       "Nervous System", True, "Female")
        self.brain_volume = brain_volume
        self.brain_weight_gram = brain_weight_gram
    # repr method that returns the attributes of brain instance
    def __repr__(self):
        return Organ.__repr__(self) + f"\nBrain volume:{self.brain_volume},\
            Brain weight:{self.brain_weight_gram}"
    # general method for brain class
    # return 'Thinking'
    def brain_status(self):
        return "Thinking"
    # return brain weight in ounces
    def brain_weight_oz(self):
        return 0.035 * self.brain_weight_gram
# main program
if __name__ == "__main__":
    # Instantiate the heart object with attributes
    heart = Heart(12, 280, 6.0, 9.0)
    # Instantiate the brain object with attribute
    brain = Brain(1260, 1370.0)
    # print heart to test
    print(heart)
    # print brain to test
    print(brain)
    # test all the parent and child attributes match what was instantiated
    # print heart attributes
    print("\nHeart Attributes:")
    print(heart.organ_name, heart.organ_weight_grams, heart.is_vital_organ,
          heart.organ_system, heart.is_transplantable, heart.organ_gender)
    print(heart.heart_length_cm, heart.heart_weight_grams, 
          heart.heart_thickness_cm, heart.heart_breadth_cm)
    # print brain attributes
    print("\nBrain Attributes:")
    print(brain.organ_name, brain.organ_weight_grams, brain.is_vital_organ,
          brain.organ_system, brain.is_transplantable, brain.organ_gender)
    print(brain.brain_volume, brain.brain_weight_gram)
    # test that the general methods return the appropriate values
    # print heart general method
    print("\nGeneral method for heart class:")
    print("Heart is {}".format(heart.heart_status()))
    print("Heart weight in ounces: {}".format(heart.heart_weight_oz()))
    # print brain general method
    print("\nGeneral method for brain class:")
    print("Brain is {}".format(brain.brain_status()))
    print("Brain weight in ounces: {}".format(brain.brain_weight_oz()))
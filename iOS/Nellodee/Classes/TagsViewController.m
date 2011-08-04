//
//  TagsViewController.m
//  Nellodee
//
//  Created by Ada Hopper on 02/08/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "TagsViewController.h"


@implementation TagsViewController

@synthesize labelText,tags;


- (void)viewDidLoad {
    UINavigationItem *navigationItem = self.navigationItem;
    navigationItem.title = @"Tags";
    self.navigationItem.rightBarButtonItem = self.editButtonItem;
}


- (void)viewDidUnload {
	self.labelText = nil;
	[super viewDidUnload];
}


- (void)viewWillAppear:(BOOL)animated {    
    // Update the views appropriately
    labelText.text = tags;
}


- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation {
    // Support all orientations except upside-down
    return (interfaceOrientation != UIInterfaceOrientationPortraitUpsideDown);
}


- (void)setEditing:(BOOL)editing animated:(BOOL)animated {
    
    [super setEditing:editing animated:animated];
    
    labelText.editable = editing;
	[self.navigationItem setHidesBackButton:editing animated:YES];
    
	/*
	 If editing is finished, update the recipe's instructions and save the managed object context.
	 */
	/*if (!editing) {
		recipe.instructions = instructionsText.text;
		
		NSManagedObjectContext *context = recipe.managedObjectContext;
		NSError *error = nil;
		if (![context save:&error]) {
			
			 Replace this implementation with code to handle the error appropriately.
			 
			 abort() causes the application to generate a crash log and terminate. You should not use this function in a shipping application, although it may be useful during development. If it is not possible to recover from the error, display an alert panel that instructs the user to quit the application by pressing the Home button.
			NSLog(@"Unresolved error %@, %@", error, [error userInfo]);
			abort();
		}
	}*/		
}


- (void)dealloc {
    [labelText release];
    [super dealloc];
}


@end

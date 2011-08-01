//
//  BasicProfileViewController.m
//  Nellodee
//
//  Created by Ada Hopper on 27/07/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "BasicProfileViewController.h"
#import "MeService.h"
#import "BasicInfo.h"
#import "NellodeeApp.h"

@implementation BasicProfileViewController

@synthesize firstName, lastName, prefName,email;
@synthesize rol, departament, college;
@synthesize tags;

- (id) init{
    self=[super init];

    return self;

}




- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    return self;
}

- (void)dealloc {
    [super dealloc];
}

- (void)didReceiveMemoryWarning
{
    // Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
    
    // Release any cached data, images, etc that aren't in use.
}

#pragma mark - View lifecycle

- (void)viewDidLoad
{
    [super viewDidLoad];
    BasicInfo * basic = [[NellodeeApp sharedNellodeeData] basicInfo] ;    
    [firstName setText:[basic firstName]];
    [lastName setText:[basic lastName]];
    [prefName setText:[basic prefName]];
    [email setText:[basic email]];
    [rol setText:[basic rol]];
    [departament setText:[basic departament]];
    [college setText:[basic college]];
    [tags setText:[basic tags]];

}

- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
    // e.g. self.myOutlet = nil;
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    // Return YES for supported orientations
    return (interfaceOrientation == UIInterfaceOrientationPortrait);
}


@end

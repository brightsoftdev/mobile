//
//  URLViewController.m
//  Nellodee
//
//  Created by Ada Hopper on 17/07/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "URLViewController.h"
#import "Authorization.h"

@implementation URLViewController

@synthesize mainViewController;
@synthesize url;

- (IBAction) saveURL{
    //Dismiss the keyboard
    [url resignFirstResponder];
    
	UIAlertView *message;
	
	if ([[url text] length]>1){
		//Crete the string to store the url
		NSString *urlSakai = [url text];
		
		//Load the class to check if the URL is valid
		Authorization* auth =[[Authorization alloc] init]; 
		if([auth checkURL:urlSakai]){
			//Store the data
			NSUserDefaults *defaults =[NSUserDefaults standardUserDefaults];
			[defaults setObject:urlSakai forKey:@"url"];
			[defaults synchronize];
		
			NSLog(@"[URL VIEW CONTROLLER] URL saved: %@",urlSakai );
			[mainViewController showLogin];
		}
		else{
			message = [[UIAlertView alloc] initWithTitle:@"Failed URL"  
												 message:@"The URL is not valid.Please try again."  
												delegate:nil  
									   cancelButtonTitle:@"OK"  
									   otherButtonTitles:nil];
			[message show];  
			
			NSLog(@"[URL VIEW CONTROLLER] The URL is not valid.");
		}
	}
	else {
		message = [[UIAlertView alloc] initWithTitle:@"Failed URL"  
											 message:@"You should introiduce a valid URL"  
											delegate:nil  
								   cancelButtonTitle:@"OK"  
								   otherButtonTitles:nil];
		[message show];  
		
		NSLog(@"[URL VIEW CONTROLLER] There is no URL.");
	}

	[message release];

}


- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)dealloc
{
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
    // Do any additional setup after loading the view from its nib.
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

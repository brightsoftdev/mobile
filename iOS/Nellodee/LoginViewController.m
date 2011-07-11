//
//  LoginViewController.m
//  Nellodee
//
//  Created by May Giménez on 6/11/11.
//
//

#import "LoginViewController.h"
#import "Authorization.h"
#import "User.h"

@implementation LoginViewController

@synthesize mainViewController;
@synthesize username, password;


-(IBAction)attemptLogin
{
	// Code for attempting the login goes here
	Authorization* auth =[[Authorization alloc] init]; 
	NSString * user = [username text];
	NSString * pass = [password text];
	
	[auth formBasedAuth:user:pass];
	[auth meService];
	// Assuming it was successful, tell MainViewController to show the Tab Bar
	[mainViewController showDashboard];
}


- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation {
    // Override to allow orientations other than the default portrait orientation.
    return YES;
}


- (void)didReceiveMemoryWarning {
    // Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
    
    // Release any cached data, images, etc that aren't in use.
}


- (void)viewDidUnload {
    [super viewDidUnload];
    // Release any retained subviews of the main view.
    // e.g. self.myOutlet = nil;
}


- (void)dealloc {
    [super dealloc];
}


@end

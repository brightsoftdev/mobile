//
//  MainViewController.m
//  TabBarTest
//
//  Created by Michael Ziray on 1/14/10.
//  
//

#import "MainViewController.h"
#import "LoginViewController.h"
#import "URLViewController.h"
#import "User.h"

@implementation MainViewController

/*
 // The designated initializer.  Override if you create the controller programmatically and want to perform customization that is not appropriate for viewDidLoad.
- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil {
    if (self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil]) {
        // Custom initialization
    }
    return self;
}
*/


// Implement viewDidLoad to do additional setup after loading the view, typically from a nib.
- (void)viewDidLoad
{
	[super viewDidLoad];
	
	// This is where we load in our first view. Simply changing this code will allow
	//  us to change which view is presented first. You can have logic that determines
	//  if ViewOne should be loaded, or another view first.
    urlView =[[URLViewController alloc] initWithNibName:@"URLViewController" bundle:nil];
    urlView.mainViewController= self;
    [mainWindow addSubview: urlView.view];
    
	//loginView = [[LoginViewController alloc] initWithNibName: @"LoginViewController" bundle:nil];
	//loginView.mainViewController = self;
	
	//[mainWindow addSubview: loginView.view];
}


// Function to load and display our Dashboard programmatically
-(void)showDashboard
{
	// Remove the previous view. In this case, viewOne
	[self.view removeFromSuperview];
	[loginView release];
	
	tabBarController = [[UITabBarController alloc] init];
	[tabBarController setHidesBottomBarWhenPushed:YES];
	
	User *u =[[User alloc] init];
	[u meService];
	
	ViewTwoController *youView = [[ViewTwoController alloc] init];
	youView.title = @"You";
	
	ViewTwoController *createAddView = [[ViewTwoController alloc] init];
	createAddView.title = @"Create + Add";

	ViewTwoController *exploreView = [[ViewTwoController alloc] init];
	exploreView.title = @"Explore";

	ViewTwoController *moreView = [[ViewTwoController alloc] init];
	moreView.title = @"More";

	[tabBarController setViewControllers: [NSArray arrayWithObjects: youView, createAddView, exploreView,moreView,nil]];

	[mainWindow addSubview: tabBarController.view];
}

// Override to allow orientations other than the default portrait orientation.
- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation {
    // Return YES for supported orientations
    return YES;// (interfaceOrientation != UIInterfaceOrientationPortraitUpsideDown);// UIInterfaceOrientationPortrait);
}


- (void)didReceiveMemoryWarning {
	// Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
	
	// Release any cached data, images, etc that aren't in use.
}

- (void)viewDidUnload {
	// Release any retained subviews of the main view.
	// e.g. self.myOutlet = nil;
}


- (void)dealloc {
    [super dealloc];
}


@end

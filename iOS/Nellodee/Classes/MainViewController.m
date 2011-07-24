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
#import "MeService.h"
#import "UserViewController.h"
@implementation MainViewController

@synthesize mainWindow,userNavController;


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
    
    // This is where we load in our first view.
	sharedNell = [NellodeeApp sharedNellodeeData];
    NSLog(@"Sakai url: %@",[sharedNell sakaiURL]);

    if( [[sharedNell sakaiURL] length] == 0){
        urlView =[[URLViewController alloc] initWithNibName:@"URLViewController" bundle:nil];
        urlView.mainViewController= self;
        [mainWindow addSubview: urlView.view];
    }
    else{
        loginView = [[LoginViewController alloc] initWithNibName: @"LoginViewController" bundle:nil];
        loginView.mainViewController = self;
	
        [mainWindow addSubview: loginView.view];
    }
    
}


// Function to load and display our Dashboard programmatically
-(void)showTabs
{
	// Remove the previous view. In this case, viewOne
	[self.view removeFromSuperview];
	[loginView release];
	
	tabBarController = [[UITabBarController alloc] init];
	[tabBarController setHidesBottomBarWhenPushed:YES];
	
	MeService *u =[[MeService alloc] init];
	[u meService];
    
    UserViewController *userView;
    userView =[[[UserViewController alloc] init] autorelease];

	ViewTwoController *youView = [[ViewTwoController alloc] init];
	youView.title = @"You";
    
    userNavController = [[UINavigationController alloc] init];
    userNavController.navigationBar.barStyle = UIBarStyleBlack;
    [userNavController pushViewController:userView animated:NO];
    userNavController.title =@"You";
	
    
	ViewTwoController *createAddView = [[ViewTwoController alloc] init];
	createAddView.title = @"Create + Add";

	ViewTwoController *exploreView = [[ViewTwoController alloc] init];
	exploreView.title = @"Explore";

	ViewTwoController *moreView = [[ViewTwoController alloc] init];
	moreView.title = @"More";

	[tabBarController setViewControllers: [NSArray arrayWithObjects: userNavController, createAddView, exploreView,moreView,nil]];

	[mainWindow addSubview: tabBarController.view];
}


// Function to load and display our Dashboard programmatically
-(void)showLogin
{
	// Remove the previous view. In this case, viewOne
	[self.view removeFromSuperview];
	[urlView release];
	    
    loginView = [[LoginViewController alloc] initWithNibName: @"LoginViewController" bundle:nil];
	loginView.mainViewController = self;
	
	[mainWindow addSubview: loginView.view];
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
    //All views should be realesed
    [userNavController release];
    [super dealloc];
}


@end

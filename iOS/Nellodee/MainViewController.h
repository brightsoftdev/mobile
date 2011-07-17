//
//  MainViewController.h
//  Nellodee
//
//  Created by Mayte Giménex on 7/10/11.
//  
//

#import <UIKit/UIKit.h>
#import "ViewTwoController.h"

@class LoginViewController;
@class URLViewController;

@interface MainViewController : UIViewController {
	IBOutlet UIWindow *mainWindow;
	UITabBarController *tabBarController;
	
	LoginViewController *loginView;
    URLViewController *urlView;
}

-(void) showTabs;
-(void) showLogin;

@end

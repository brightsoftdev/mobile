//
//  MainViewController.h
//  Nellodee
//
//  Created by Mayte Giménex on 7/10/11.
//  
//

#import <UIKit/UIKit.h>
#import "ViewTwoController.h"
#import "NellodeeApp.h"

@class LoginViewController;
@class URLViewController;

@interface MainViewController : UIViewController {
    
    //Views
    IBOutlet UIWindow *mainWindow;
    UITabBarController *tabBarController;
    UINavigationController *userNavController;
    
    LoginViewController *loginView;
    URLViewController *urlView;
    
    //Nellodee shared data
    NellodeeApp *sharedNell;
}

-(void) showLogin;
-(void) showTabs;

@property (nonatomic, retain) IBOutlet UIWindow *mainWindow;
@property (nonatomic, retain) UINavigationController *userNavController;

@end

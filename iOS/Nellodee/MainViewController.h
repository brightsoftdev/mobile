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

@interface MainViewController : UIViewController {
	IBOutlet UIWindow *mainWindow;
	
	LoginViewController *loginView;
}

-(void)showDashboard;


@end

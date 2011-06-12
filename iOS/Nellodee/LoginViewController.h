//
//  LoginViewController.h
//  Nellodee
//
//  Created by May Giménez on 6/11/11.
//
//

#import <UIKit/UIKit.h>

#import "MainViewController.h"

@interface LoginViewController : UIViewController
{
	MainViewController *mainViewController;

	IBOutlet UITextField * username;
	IBOutlet UITextField * password;

}


-(IBAction)attemptLogin; // action to be performed when login button is touched


@property (nonatomic, retain) MainViewController *mainViewController;
@property (nonatomic, retain) UITextField *username;
@property (nonatomic, retain) UITextField *password;

@end

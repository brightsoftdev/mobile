//
//  BasicProfileViewController.h
//  Nellodee
//
//  Created by Ada Hopper on 27/07/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>

@class BasicInfo;

@interface BasicProfileViewController : UITableViewController <UINavigationControllerDelegate, UIImagePickerControllerDelegate, UITextFieldDelegate>{
    IBOutlet UIImageView * imageView;
    IBOutlet UITextField * firstName;
	IBOutlet UITextField * lastName;
    IBOutlet UITextField * prefName;
	IBOutlet UITextField * email;
    IBOutlet UITextField * rol;
	IBOutlet UITextField * departament;
    IBOutlet UITextField * college;
	IBOutlet UITextField * tags;
    
    UIView *tableHeaderView;    
    
@private
    UIButton *photoButton;
    UITextField *firstNameTextField;
    UITextField *lastNameTextField;
    UITextField *prefNameTextField;
    UITextField *prepTimeTextField;


}
@property (nonatomic, retain) UITextField *firstName;
@property (nonatomic, retain) UITextField *lastName;
@property (nonatomic, retain) UITextField *prefName;
@property (nonatomic, retain) UITextField *email;
@property (nonatomic, retain) UITextField *rol;
@property (nonatomic, retain) UITextField *departament;
@property (nonatomic, retain) UITextField *college;
@property (nonatomic, retain) UITextField *tags;

@property (nonatomic, retain) IBOutlet UIView *tableHeaderView;
@property (nonatomic, retain) IBOutlet UIButton *photoButton;
@property (nonatomic, retain) IBOutlet UITextField *firstNameTextField;
@property (nonatomic, retain) IBOutlet UITextField *lastNameTextField;
@property (nonatomic, retain) IBOutlet UITextField *prefNameTextField;
//@property (nonatomic, retain) IBOutlet UITextField *emailTextField;


@end

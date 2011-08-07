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
    
    BasicInfo * basic;
    
@private
    UIView *tableHeaderView;    
    UIButton *photoButton;
    UITextField *firstNameTextField;
    UITextField *lastNameTextField;
    UITextField *prefNameTextField;


}

@property (nonatomic, retain) BasicInfo * basic;
@property (nonatomic, retain) IBOutlet UIView *tableHeaderView;
@property (nonatomic, retain) IBOutlet UIButton *photoButton;
@property (nonatomic, retain) IBOutlet UITextField *firstNameTextField;
@property (nonatomic, retain) IBOutlet UITextField *lastNameTextField;
@property (nonatomic, retain) IBOutlet UITextField *prefNameTextField;


@end

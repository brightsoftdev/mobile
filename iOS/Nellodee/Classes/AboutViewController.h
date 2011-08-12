//
//  AboutViewController.h
//  Nellodee
//
//  Created by Ada Hopper on 04/08/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>

@class About;

@interface AboutViewController : UITableViewController <UINavigationControllerDelegate, UITextFieldDelegate>{
    @private
        About * about;
}
    
@property (nonatomic, retain)  About * about;
    
    
@end


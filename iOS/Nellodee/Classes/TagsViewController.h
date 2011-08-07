//
//  TagsViewController.h
//  Nellodee
//
//  Created by Ada Hopper on 02/08/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>


@interface TagsViewController : UIViewController {
    UITextView *labelText;
    NSString *tags;
}
@property (nonatomic, retain) IBOutlet UITextView *labelText;
@property (nonatomic, retain) NSString *tags;
@end

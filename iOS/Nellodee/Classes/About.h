//
//  About.h
//  Nellodee
//
//  Created by Ada Hopper on 17/07/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <Foundation/Foundation.h>


@interface About : NSObject {
    NSString *aboutMe;
    NSString *academicInterests;
    NSString *personalInterests;
    NSString *hobbies;
    
}
@property (nonatomic,retain) NSString *aboutMe;
@property (nonatomic,retain) NSString *academicInterests;
@property (nonatomic,retain) NSString *personalInterests;
@property (nonatomic,retain) NSString *hobbies;

@end
